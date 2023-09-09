package com.wnxy.lqc.utils;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    @SneakyThrows
    public static <T> T selectOne(String sql, Class<T> clazz, Object... params) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            T t = covert2Entity(resultSet, clazz);
            return t;
        }
        DBUtil.closeConnection(connection);
        return null;

    }

    // 通用计数方法
    public static Long getCount(String sql, Object... params) {
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return 0L;
    }

    //通用的查询方法
    public static <T> List<T> selectList(String sql, Class<T> clazz, Object... params) {
        List<T> list = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                T t = covert2Entity(resultSet, clazz);
                list.add(t);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @SneakyThrows
    private static <T> T covert2Entity(ResultSet resultSet, Class<T> clazz) {
        //1.创建类型T的对象（反射）通过得到这个T的字节码就可以创建对象了
        T instance = clazz.newInstance();
        //2.动态的从res中取出属性值，填充到上一步的对象中
        //要知道resulSet究竟取了哪些列
        ResultSetMetaData metaData = resultSet.getMetaData();//结果集中的元数据（档案）
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String label = metaData.getColumnLabel(i);//取出第一列的列名或别名
            //通过别名，既属性名找属性信息对象Field
            Field field = getField(clazz, label);
            Object value = resultSet.getObject(label);
            field.setAccessible(true);
            field.set(instance, value);
        }
        return instance;
    }

    private static Field getField(Class<?> clazz, String label) {
        try {
            Field field = clazz.getDeclaredField(label);
            return field;
        } catch (NoSuchFieldException e) {
            //看clazz有没有父类
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null) {
                return getField(superclass, label);
            } else {
                throw new RuntimeException(e);
            }
        }
    }


    //有两个变化点，（1.sql语句,2，参数(参数数量不确定，类型不确定)）
    public static void execute(String sql, Object... params) {
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //params 可以作为数组使用
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
    }
}

