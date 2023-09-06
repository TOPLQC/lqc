package com.wnxy.crm06.dao;

import com.wnxy.crm06.dto.RecordDto;
import com.wnxy.crm06.entity.Record;

import java.util.List;

public interface RecordDao {
    void addRecord(Record record);

    List<RecordDto> getMyRecord();
}
