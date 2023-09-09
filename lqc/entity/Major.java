package com.wnxy.lqc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Major {
    private Integer mid;
    private String mname;
    private Integer departmentId;
    private LocalDateTime entryDate;
}
