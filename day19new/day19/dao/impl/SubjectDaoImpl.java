package com.wnxy.day19new.day19.dao.impl;

import com.wnxy.day19.dao.SubjectDao;
import com.wnxy.day19.entity.Subject;
import com.wnxy.day19.utils.DBUtil;
import com.wnxy.day19new.day19.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {
    @Override

    public List<Subject> getAllSubjects() {
        String sql = "select id,name,grade_id as gradeId,class_hour as classHours from subject";

        List<Subject> subjects = JdbcUtil.selectList(sql, Subject.class);
        return subjects;
    }

    @Override
    public void update(Subject subject) {
        String sql = "update subject set name = ?,class_hour=?,grade_id=? where id = ?";
        JdbcUtil.execute(sql,
                subject.getName(),
                subject.getClassHours(),
                subject.getGradeId(),
                subject.getId());

//        Connection connection = DBUtil.getConnection();
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setObject(1, subject.getName());
//            statement.setObject(2, subject.getClassHours());
//            statement.setObject(3, subject.getGradeId());
//            statement.setObject(4, subject.getId());
//            statement.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            DBUtil.closeConnection(connection);
//        }
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

        String sql = "select id,name,grade_id as gradeId , " +
                "class_hour as classHours from subject where name like concat('%',?,'%')";
        List<Subject> subjects = JdbcUtil.selectList(sql, Subject.class, keyword);
        return subjects;
    }

    @Override
    public void addSubject(Subject subject) {
        String sql = "insert into subject values(null,?,?,?)";
        JdbcUtil.execute(sql,
                subject.getName(),
                subject.getClassHours(),
                subject.getGradeId());
//        Connection connection = DBUtil.getConnection();
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setObject(1, subject.getName());
//            statement.setObject(2, subject.getClassHours());
//            statement.setObject(3, subject.getGradeId());
//            statement.execute();   //别忘了加执行语句
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            DBUtil.closeConnection(connection);
//        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from subject where id = ?";
        JdbcUtil.execute(sql, id);
//        Connection connection = DBUtil.getConnection();
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setObject(1, id);
//
//            statement.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            DBUtil.closeConnection(connection);
//        }
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
