package com.wnxy.day19.dao.impl;

import com.wnxy.day19.dao.SubjectDao;
import com.wnxy.day19.entity.Subject;
import com.wnxy.day19.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        }
        return subjects;
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
