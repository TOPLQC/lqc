package com.wnxy.lqc.dto;

import com.wnxy.lqc.entity.Major;
import lombok.Data;

@Data
public class MajorDto extends Major {
    private String dname;
    private Long majorCount;

}
