package com.wnxy.crm06.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private Integer id;
    private Integer customerId;
    private Integer employeeId;
    private String rtype;
    private String remark;
    private LocalDateTime createtime;
}