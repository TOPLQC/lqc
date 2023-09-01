package com.wnxy.day19new.day19.entity;


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

    public Subject(String name, Integer classHours, Integer gradeId) {
        this.name = name;
        this.classHours = classHours;
        this.gradeId = gradeId;
    }
}
