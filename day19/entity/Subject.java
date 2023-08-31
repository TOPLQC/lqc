package com.wnxy.day19.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    private Integer id;
    private String name;
    private Integer classHours;
    private Integer gradeId;
}
