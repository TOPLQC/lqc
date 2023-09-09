package com.wnxy.lqc.dao;

import com.wnxy.lqc.dto.StudentDto;
import com.wnxy.lqc.entity.Student;

import java.util.List;

public interface StudentDao {
    List<StudentDto> getStudentBynName(String name);

    List<Student> getRepeatStudent();
}
