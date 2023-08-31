package com.wnxy.day19.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static String url = "jdbc:mysql://localhost:3306/gzwn_j06?serverTimezone=Asia/Shanghai";
    private static String driveName = "com.mysql.cj.jdbc.Driver";
    private static String userName = "root";
    private static String password = "123456";

    static {
        try {
            Class.forName(driveName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
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
