package com.wnxy.crm06.dao.impl;

import com.wnxy.crm06.ApplicationContext;
import com.wnxy.crm06.dao.RecordDao;
import com.wnxy.crm06.dto.RecordDto;
import com.wnxy.crm06.entity.Record;
import com.wnxy.crm06.utils.JdbcUtil;

import java.util.List;

public class RecordDaoImpl implements RecordDao {
    @Override
    public void addRecord(Record record) {
        String sql = "insert into record(customerId, employeeId, rtype, remark) VALUES (?,?,?,?)";
        JdbcUtil.execute(sql,
                record.getCustomerId(),
                ApplicationContext.CURRENT_EMP.getId(),
                record.getRtype(),
                record.getRemark());
    }

    public List<RecordDto> getMyRecord() {
        String sql = "SELECT record.*, customer.cname, employee.ename " +
                "FROM record INNER JOIN employee ON record.employeeId = employee.id " +
                "INNER JOIN customer ON record.customerId = customer.id " +
                "WHERE employee.id = ? AND employee.state = 1";
        List<RecordDto> recordDtos = JdbcUtil.selectList(sql, RecordDto.class, ApplicationContext.CURRENT_EMP.getId());
        return recordDtos;
    }

}
