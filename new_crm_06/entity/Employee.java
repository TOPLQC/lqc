package com.wnxy.new_crm_06.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String account;
    private String password;
    private String ename;
    private LocalDateTime createtime;
    private Integer state;
}