package com.wnxy.lqc.dao.impl;

import com.wnxy.lqc.dao.DepartmentDao;
import com.wnxy.lqc.dto.DepartmentDto;
import com.wnxy.lqc.utils.JdbcUtil;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public void addDepartment(String dname) {
        String sql = "INSERT INTO department (dname) VALUES (?)";
        JdbcUtil.execute(sql, dname);
    }

    @Override
    public List<DepartmentDto> selectStudentByMajors() {
        String sql = "SELECT did , dname , mname , sname ,age FROM department INNER JOIN major  ON did = departmentId " +
                "INNER JOIN student AS s ON mid = s.majorId ORDER BY dname, mname, sname";
        List<DepartmentDto> list = JdbcUtil.selectList(sql, DepartmentDto.class);
        return list;
    }
}
