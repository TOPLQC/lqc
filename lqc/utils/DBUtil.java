package com.wnxy.lqc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {


    static {
        try {
            Class.forName(PropertyUtil.getProperty("jdbc.driverName"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(
                    PropertyUtil.getProperty("jdbc.url"),
                    PropertyUtil.getProperty("jdbc.username"),
                    PropertyUtil.getProperty("jdbc.password"));
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
