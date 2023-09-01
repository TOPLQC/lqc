package com.wnxy.day19new.day19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String stuName;
    private String email;
    private String address;
    private Integer age;
    private Boolean sex;
    private Date entryTime;
    private int gradeId;
}
