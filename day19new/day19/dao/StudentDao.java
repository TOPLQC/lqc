package com.wnxy.day19new.day19.dao;

import com.wnxy.day19.entity.Student;

import java.time.LocalDateTime;
import java.util.List;

public interface StudentDao {
    List<Student> getAllStudent();

    List<Student> getStudentBySex(Boolean sex);

    List<Student> getStudentByAgeRange(Integer minAge, Integer maxAge);

    List<Student> getStudentByDate(LocalDateTime date);

    List<Student> getStudentByAddress(String address);
}
