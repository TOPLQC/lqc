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
    private String ename;
    private String cname;

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id + ", " +
                "ename='" + ename + '\'' +
                ", cname='" + cname + '\'' +
                ", rtype='" + rtype + '\'' +
                ", remark='" + remark + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}