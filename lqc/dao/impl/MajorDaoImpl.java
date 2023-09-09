package com.wnxy.lqc.dao.impl;

import com.wnxy.lqc.dao.MajorDao;
import com.wnxy.lqc.dto.MajorDto;
import com.wnxy.lqc.utils.JdbcUtil;

import java.util.List;

public class MajorDaoImpl implements MajorDao {
    @Override
    public List<MajorDto> selectMoreThanTwoMajors() {
        String sql = "SELECT dname, COUNT(mid) AS majorCount FROM department INNER JOIN major ON did = departmentId GROUP BY dname HAVING COUNT(mid) > 2";
        List<MajorDto> list = JdbcUtil.selectList(sql, MajorDto.class);
        return list;
    }

    @Override
    public List<MajorDto> selectMoreThanTwoMajorsOnlyName() {
        String sql = "SELECT dname " +
                "FROM department " +
                "INNER JOIN major ON did = departmentId " +
                "GROUP BY dname " +
                "HAVING COUNT(mid) > 2";
        List<MajorDto> majors = JdbcUtil.selectList(sql, MajorDto.class);
        return majors;
    }

}
