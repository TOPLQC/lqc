package com.wnxy.lqc.dao;

import com.wnxy.lqc.dto.MajorDto;

import java.util.List;

public interface MajorDao {
    List<MajorDto> selectMoreThanTwoMajors();

    List<MajorDto> selectMoreThanTwoMajorsOnlyName();
}
