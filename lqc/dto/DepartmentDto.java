package com.wnxy.lqc.dto;

import com.wnxy.lqc.entity.Department;

public class DepartmentDto extends Department {
    private String mname;
    private String sname;
    private Integer age;

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "mname='" + mname + '\'' +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                super.toString() +
                '}';
    }
}
