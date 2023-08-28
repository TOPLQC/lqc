package com.wnxy.zhoukao.student.dao.impl;

import com.wnxy.zhoukao.student.dao.StudentDao;
import com.wnxy.zhoukao.student.entity.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentDaoImpl implements StudentDao {
    private final ArrayList<Student> students;
    int id = 8;

    {
        students = new ArrayList<>();
        {
            students.add(new Student(2, "lqc", "六年级", "广西", 18));
            students.add(new Student(3, "张wy", "二年级", "云南", 28));
            students.add(new Student(1, "lzx", "一年级", "广东", 14));
            students.add(new Student(4, "az", "四年级", "广西", 8));
            students.add(new Student(6, "hmbb", "六年级", "广西", 25));
            students.add(new Student(5, "张x", "六年级", "广东", 18));
            students.add(new Student(7, "hg", "三年级", "云南", 22));
        }
    }


    @Override
    public List<Student> showAllStudent() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        student.setId(id);
        id++;
        students.add(student);
    }

    @Override
    public Map<String, Long> selectStudentCountByGrade() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
    }

    @Override
    public boolean updateStudentInfo(Integer id, String city, String grade) {

        if (id > students.size()) {
            return false;
        }
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                student.setCity(city);
                student.setGrade(grade);
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteStudentById(Integer id) {
        if (id > students.size()) {
            return;
        }
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public Map<String, Long> selectStudentCountByAllCity() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getCity, Collectors.counting()));
    }

    @Override
    public Long selectFirstNameByZhang() {
        return students.stream().
                filter(student -> student.getName().startsWith("张"))
                .count();
    }
}
