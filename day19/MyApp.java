package com.wnxy.day19;

import com.wnxy.day19.dao.StudentDao;
import com.wnxy.day19.entity.Student;
import com.wnxy.day19.factory.DaoFactory;

import java.time.LocalDateTime;
import java.util.List;

public class MyApp {
    static StudentDao studentDao = DaoFactory.creatCustomerDao();

    public static void main(String[] args) {
        getStudentByAddress();
    }

    public static void getStudentByAddress() {
        String address = "河北";
        List<Student> studentByAddress = studentDao.getStudentByAddress(address);
        studentByAddress.forEach(System.out::println);
    }

    public static void getStudentByDate() {
        LocalDateTime date = LocalDateTime.of(2020, 1, 1, 1, 1);
        List<Student> studentByDate = studentDao.getStudentByDate(date);
        studentByDate.forEach(System.out::println);
    }

    public static void getStudentByAgeRange() {
        List<Student> studentByAgeRange = studentDao.getStudentByAgeRange(18, 25);
        studentByAgeRange.forEach(System.out::println);
    }

    public static void getStudentBySex() {
        List<Student> studentBySex = studentDao.getStudentBySex(true);
        studentBySex.forEach(System.out::println);
    }

    public static void showAllStudent() {
        List<Student> students = studentDao.getAllStudent();
        students.forEach(System.out::println);
    }


//    public static void test() {
//        Connection connection = DBUtil.getConnection();
//        if (connection != null) {
//            System.out.println(connection);
//        }
//    }
//
//    public static void testGetKeyword() {
//        SubjectDao subjectDao = new SubjectDaoImpl();
//        String key="数";
//        List<Subject> keyword = subjectDao.getKeyword(key);
//        keyword.forEach(System.out::println);
//    }
//
//    public static void testGetById() {
//        SubjectDao subjectDao = new SubjectDaoImpl();
//        Integer id = 1;
//        Subject subject = subjectDao.getById(id);
//
//        if (subject == null) {
//            System.out.println("没找到数据");
//            return;
//        }
//        System.out.println(subject);
//
//    }
//
//    public static void testGetByName() {
//        SubjectDao subjectDao = new SubjectDaoImpl();
//        String name = "' or 1=1 -- ";
//        Subject subject = subjectDao.getByName(name);
//
//        if (subject == null) {
//            System.out.println("没找到数据");
//            return;
//        }
//        System.out.println(subject);
//
//    }
//
//    public static void getAllSubjects1() {
//        SubjectDao subjectDao = new SubjectDaoImpl();
//        List<Subject> subjects = subjectDao.getAllSubjects();
//        subjects.forEach(System.out::println);
//    }
//
//
//    public static void getAllSubjects() {
//        String sql = "select id, name, class_hour, grade_id from subject";
//        Connection connection = null;
//        try {
//            connection = DBUtil.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                System.out.printf("%s - %s - %s - %s\n", resultSet.getInt(1),
//                        resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//
//        } finally {
//            try {
//                DBUtil.closeConnection(connection);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//
//            }
//        }
//    }
//
//    public static void testCreatConnection() {
//        String url = "jdbc:mysql://localhost:3306/gzwn_j06?serverTimezone=Asia/Shanghai";
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection(url, "root", "123456");
//            if (conn != null) {
//                System.out.println("链接成功啦！！！：" + conn);
//            } else {
//                System.out.println("失败了捏");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}

