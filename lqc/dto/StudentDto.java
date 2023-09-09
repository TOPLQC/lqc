package com.wnxy.lqc.dto;

import com.wnxy.lqc.entity.Student;

public class StudentDto extends Student {
    private String mname;

    @Override
    public String toString() {
        return "RecordDto{" +
                "ename='" + mname + '\'' +
                super.toString() +
                '}';
    }
}
