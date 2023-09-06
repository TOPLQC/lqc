package com.wnxy.crm06.utils;

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

    @SneakyThrows
    public static <T> List<T> test(String sql, Class<T> clazz, Object... params) {
        List<T> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement stat = conn.prepareStatement(sql);
        for (int i = 0; i > params.length; i++) {
            stat.setObject(i + 1, params[i]);
        }
        ResultSet res = stat.executeQuery();
        while (res.next()) {
            T t = covert2Entity(res, clazz);
            list.add(t);
        }
        DBUtil.closeConnection(conn);
        return list;
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
            Field field = clazz.getDeclaredField(label);
            Object value = resultSet.getObject(label);
            field.setAccessible(true);
            field.set(instance, value);
        }
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

    @SneakyThrows
    public static <T> T getList(String sql, Class<T> clazz, Object... pars) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement sta = conn.prepareStatement(sql);
        for (int i = 0; i < pars.length; i++) {
            sta.setObject(i + 1, pars[i]);
        }
        ResultSet res = sta.executeQuery();
        while (res.next()) {
            return covert2Entity(res, clazz);
        }
        DBUtil.closeConnection(conn);
        return null;
    }

    @SneakyThrows
    public static <T> List<T> test3(String sql, Class<T> clazz, Object... params) {
        List<T> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement stat = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stat.setObject(i + 1, params[i]);
        }
        ResultSet res = stat.executeQuery();
        while (res.next()) {
            T t = covert2Entity(res, clazz);
            list.add(t);
        }
        DBUtil.closeConnection(conn);
        return list;
    }

    @SneakyThrows
    public static <T> List<T> test4(String sql, Class<T> clazz, Object... params) {
        List<T> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement stat = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stat.setObject(i + 1, params[i]);
        }
        ResultSet res = stat.executeQuery();
        while (res.next()) {
            T t = covert2Entity(res, clazz);
            list.add(t);
        }
        DBUtil.closeConnection(conn);
        return list;
    }

    @SneakyThrows
    public static <T> List<T> test5(String sql, Class<T> clazz, Object... params) {
        List<T> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement stat = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stat.setObject(i + 1, params[i]);
        }
        ResultSet res = stat.executeQuery();
        while (res.next()) {
            T t = covert2Entity(res, clazz);
            list.add(t);
        }
        DBUtil.closeConnection(conn);
        return list;
    }


    @SneakyThrows
    public static <T> T test1(ResultSet res, Class<T> clazz) {
        T ins = clazz.newInstance();
        ResultSetMetaData meta = res.getMetaData();
        int j = meta.getColumnCount();
        for (int i = 0; i < j; i++) {
            String l = meta.getColumnLabel(i);
            Field f = clazz.getDeclaredField(l);
            Object v = res.getObject(l);
            f.setAccessible(true);
            f.set(v, ins);

        }
        return ins;
    }

    @SneakyThrows
    public static <T> List<T> test1(String sql, Class<T> clazz, Object... params) {
        List<T> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement stat = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stat.setObject(i + 1, params[i]);
        }
        ResultSet res = stat.executeQuery();
        while (res.next()) {
            T t = covert2Entity(res, clazz);
            list.add(t);
        }
        DBUtil.closeConnection(conn);
        return list;
    }

    @SneakyThrows
    public static <T> T test(ResultSet res, Class<T> clazz) {
        T ins = clazz.newInstance();
        ResultSetMetaData meta = res.getMetaData();
        int c = meta.getColumnCount();
        for (int i = 0; i < c; i++) {
            String l = meta.getColumnLabel(i);
            Field f = clazz.getDeclaredField(l);
            Object v = res.getObject(l);
            f.setAccessible(true);
            f.set(v, ins);
        }
        return ins;
    }

    @SneakyThrows
    public static <T> List<T> test12(String sql, Class<T> clazz, Object... params) {
        List<T> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement stat = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stat.setObject(i + 1, params[i]);
        }
        ResultSet res = stat.executeQuery();
        while (res.next()) {
            T t = covert2Entity(res, clazz);
            list.add(t);
        }
        DBUtil.closeConnection(conn);
        return list;
    }
//    @SneakyThrows
//    public static <T> T test1(ResultSet res,Class<T> clazz){
//        T ins = clazz.newInstance();
//        ResultSetMetaData meta = res.getMetaData();
//        int c = meta.getColumnCount();
//        for(int i = 0; i < c; i++){
//            String l = meta.getColumnLabel(i);
//            Field f = clazz.getDeclaredField(l);
//            Object v = res.getObject(l);
//            f.setAccessible(true);
//            f.set(v,ins);
//        }
//        return ins;
}

