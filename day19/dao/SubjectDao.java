package com.wnxy.day19.dao;

import com.wnxy.day19.entity.Subject;

import java.util.List;

public interface SubjectDao {
    List<Subject> getAllSubjects();

    Subject getByName(String name);

    Subject getById(Integer id);

    List<Subject> getKeyword(String keyword);

}
