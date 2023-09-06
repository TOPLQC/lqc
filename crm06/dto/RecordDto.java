package com.wnxy.crm06.dto;

import com.wnxy.crm06.entity.Record;
import lombok.Data;

@Data
public class RecordDto extends Record {
    private String ename;
    private String cname;

    @Override
    public String toString() {
        return "RecordDto{" +
                "ename='" + ename + '\'' +
                ", cname='" + cname + '\'' +
                super.toString() +
                '}';
    }
}
