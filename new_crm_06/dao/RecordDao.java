package com.wnxy.new_crm_06.dao;

import com.wnxy.new_crm_06.entity.Record;

import java.util.List;

public interface RecordDao {
    void addRecord(Record record);

    List<Record> getMyRecord();
}
