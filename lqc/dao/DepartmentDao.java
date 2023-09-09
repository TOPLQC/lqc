package com.wnxy.lqc.dao;

import com.wnxy.lqc.dto.DepartmentDto;

import java.util.List;

public interface DepartmentDao {
    void addDepartment(String dname);

    List<DepartmentDto> selectStudentByMajors();

}
