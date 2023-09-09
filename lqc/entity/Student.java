package com.wnxy.lqc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer sid;
    private String sname;
    private Integer age;
    private Integer majorId;
}
