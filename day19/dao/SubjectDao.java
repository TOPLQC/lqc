package com.wnxy.day19.dao;

import com.wnxy.day19.entity.Subject;

import java.util.List;

public interface SubjectDao {
    List<Subject> getAllSubjects();

    void update(Subject subject);

    Subject getByName(String name);

    Subject getById(Integer id);

    List<Subject> getKeyword(String keyword);

    void addSubject(Subject subject);

    void deleteById(Integer id);

}
