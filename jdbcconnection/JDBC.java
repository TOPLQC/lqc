package com.wnxy.jdbcconnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC {
    public static void getConnection() {
        try {
            // 加载配置文件
            Properties properties = new Properties();
            InputStream resourceAsStream = JDBC.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resourceAsStream);

            // 读取连接信息
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("链接成功");
                connection.close();
                return;
            }
            System.out.println("失败！");
            // 关闭连接
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
