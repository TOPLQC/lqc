package com.wnxy.lqc.dao.impl;

import com.wnxy.lqc.dao.StudentDao;
import com.wnxy.lqc.dto.StudentDto;
import com.wnxy.lqc.entity.Student;
import com.wnxy.lqc.utils.JdbcUtil;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<StudentDto> getStudentBynName(String name) {
        String lastNameWithWildcard = name + "%";
        String sql = "SELECT s.*, m.mname AS mname FROM student AS s INNER JOIN major AS m ON s.majorId = m.mid WHERE s.sname LIKE ? ORDER BY s.age";
        List<StudentDto> studentDtos = JdbcUtil.selectList(sql, StudentDto.class, lastNameWithWildcard);
        return studentDtos;
    }

    @Override
    public List<Student> getRepeatStudent() {
        String sql = "SELECT * FROM student WHERE `sname` IN (SELECT `sname` " +
                "FROM student GROUP BY `sname` HAVING COUNT(*) > 1);";
        List<Student> students = JdbcUtil.selectList(sql, Student.class);
        return students;
    }
}
