package com.wnxy.day19.dao.impl;

import com.wnxy.day19.dao.StudentDao;
import com.wnxy.day19.entity.Student;
import com.wnxy.day19.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
//查询全部学员
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, stu_name as stuName , email, address , age , sex , " +
                "entry_time as entryTime , grade_id as gradeId FROM student";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = converse2Subject(resultSet);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return students;
    }
    //根据性别查询学员
    @Override
    public List<Student> getStudentBySex(Boolean sex) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, stu_name as stuName , email, address ,age , " +
                "sex ,entry_time as entryTime , grade_id as gradeId FROM student where sex = ?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, sex);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = converse2Subject(resultSet);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return students;
    }

    @Override
    //查询年龄在18~25之间的学员
    public List<Student> getStudentByAgeRange(Integer minAge, Integer maxAge) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, stu_name as stuName , email, address ,age , sex , entry_time" +
                " as entryTime , grade_id as gradeId FROM student where age >= ? and age < ?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, minAge);
            statement.setObject(2, maxAge);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = converse2Subject(resultSet);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return students;
    }

    @Override
    //查询指定日期之前入学的学员
    public List<Student> getStudentByDate(LocalDateTime date) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, stu_name as stuName , email, address ,age , sex ," +
                "entry_time as entryTime , grade_id as gradeId FROM student where entry_time < ?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, date);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = converse2Subject(resultSet);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return students;
    }


    @Override
    //根据地址查询学员
    public List<Student> getStudentByAddress(String address) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, stu_name as stuName , email, address ,age , sex , " +
                "entry_time as entryTime , grade_id as gradeId FROM student where address = ?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, address);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = converse2Subject(resultSet);
                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return students;
    }

    private Student converse2Subject(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setStuName(resultSet.getString("stuName"));
        student.setEmail(resultSet.getString("email"));
        student.setAddress(resultSet.getString("address"));
        student.setAge(resultSet.getInt("age"));
        student.setSex(resultSet.getBoolean("sex"));
        student.setEntryTime(resultSet.getDate("entryTime"));
        student.setGradeId(resultSet.getInt("gradeId"));
        return student;

    }
}