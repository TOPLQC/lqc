package com.wnxy.day19;

import com.wnxy.day19.dao.SubjectDao;
import com.wnxy.day19.dao.impl.SubjectDaoImpl;
import com.wnxy.day19.entity.Subject;
import com.wnxy.day19.utils.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class MyApp {
    public static void main(String[] args) {
        getAllSubjects1();
    }

    public static void test() {
        Connection connection = DBUtil.getConnection();
        if (connection != null) {
            System.out.println(connection);
        }
    }

    public static void getAllSubjects1() {
        SubjectDao subjectDao = new SubjectDaoImpl();
        List<Subject> subjects = subjectDao.getAllSubjects();
        subjects.forEach(System.out::println);
    }


    public static void getAllSubjects() {
        String sql = "select id, name, class_hour, grade_id from subject";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.printf("%s - %s - %s - %s\n", resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            try {
                DBUtil.closeConnection(connection);
            } catch (Exception e) {
                throw new RuntimeException(e);

            }
        }
    }

    public static void testCreatConnection() {
        String url = "jdbc:mysql://localhost:3306/gzwn_j06?serverTimezone=Asia/Shanghai";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "123456");
            if (conn != null) {
                System.out.println("链接成功啦！！！：" + conn);
            } else {
                System.out.println("失败了捏");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

