package com.wnxy.zhoukao.student.dao;

import com.wnxy.zhoukao.student.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Student> showAllStudent();

    void addStudent(Student student);

    Map<String, Long> selectStudentCountByGrade();

    boolean updateStudentInfo(Integer id, String city, String grade);

    void deleteStudentById(Integer id);

    Map<String, Long> selectStudentCountByAllCity();

    Long selectFirstNameByZhang();

}
