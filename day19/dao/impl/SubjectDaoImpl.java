package com.wnxy.day19.dao.impl;

import com.wnxy.day19.dao.SubjectDao;
import com.wnxy.day19.entity.Subject;
import com.wnxy.day19.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {
    @Override


    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        String sql = "select id,name,grade_id as gradeId,class_hour as ClassHour from subject";
        Connection connection = DBUtil.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { //读到了一条记录
                //将读到的记录转换为一个实体类对象
                Subject subject = converse2Subject(resultSet);
                subjects.add(subject);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return subjects;
    }

    @Override
    public Subject getByName(String name) {
        String sql = "select id,name,grade_id as gradeId , " +
                "class_hour as ClassHour from subject where name = ?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return converse2Subject(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return null;
    }

    @Override
    public Subject getById(Integer id) {
        String sql = "select id,name,grade_id as gradeId , " +
                "class_hour as ClassHour from subject where id = ?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Subject subject = converse2Subject(resultSet);
                return subject;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Subject> getKeyword(String keyword) {
        List<Subject> subjects = new ArrayList<>();
        String sql = "select id,name,grade_id as gradeId , " +
                "class_hour as ClassHour from subject where name like concat('%',?,'%')";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, keyword);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Subject subject = converse2Subject(resultSet);
                subjects.add(subject);
                return subjects;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return null;
    }

    private Subject converse2Subject(ResultSet resultSet) throws SQLException {
        Subject subject = new Subject();
        subject.setClassHours(resultSet.getInt("classHour"));
        subject.setId(resultSet.getInt("gradeId"));
        subject.setGradeId(resultSet.getInt("gradeId"));
        subject.setName(resultSet.getString("name"));
        return subject;
    }
}
