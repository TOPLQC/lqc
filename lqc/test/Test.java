package com.wnxy.lqc.test;

import com.wnxy.lqc.utils.DBUtil;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
        if (connection != null) {
            System.out.println("成功！");
            DBUtil.closeConnection(connection);
        }
    }
}
