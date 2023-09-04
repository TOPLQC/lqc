package com.wnxy.crm06.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id; //所有的属性都是用包装类
    private String cname;
    private String mobile;
    private Integer age;
    private Boolean gender;
    private String education;
    private LocalDateTime createtime;
    private Integer state;
}

