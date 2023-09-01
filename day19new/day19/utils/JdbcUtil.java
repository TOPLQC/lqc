package com.wnxy.day19new.day19.utils;

import com.wnxy.day19.utils.DBUtil;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    //通用的查询方法
    public static <T> List<T> selectList(String sql, Class<T> clazz, Object... params) {
        ArrayList<T> list = new ArrayList<>();
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
            Field field = clazz.getDeclaredField(label);
            Object value = resultSet.getObject(label);
            field.setAccessible(true);
            field.set(instance, value);
        }

/*
        try {
            T entity = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                // 获取字段名，假设字段名与数据库列名一致
                String fieldName = field.getName();

                // 使用 ResultSet 的 getX 方法根据字段名获取相应的值
                // 注意：这里的字段名需要与数据库中的列名一致，且大小写敏感
                Object value = resultSet.getObject(fieldName);

                // 设置实体对象的属性
                field.setAccessible(true); // 允许访问私有属性
                field.set(entity, value);
            }
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert ResultSet to entity", e);
            }
*/
        return instance;
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
