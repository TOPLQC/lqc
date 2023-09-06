package com.wnxy.new_crm_06.dao.impl;

import com.wnxy.new_crm_06.ApplicationContext;
import com.wnxy.new_crm_06.dao.RecordDao;
import com.wnxy.new_crm_06.entity.Record;
import com.wnxy.new_crm_06.utils.JdbcUtil;

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

//    @Override
//    public List<Map<String, Object>> geyMyRecord() {
//        List<Map<String, Object>> resultList = new ArrayList<>();
//        Connection connection = null;
//        try {
//            connection = DBUtil.getConnection();
//            String sql = "SELECT record.id, customer.cname, employee.ename, " +
//                    "rtype, remark, record.createtime " +
//                    "FROM record " +
//                    "INNER JOIN employee ON record.employeeId = employee.id " +
//                    "INNER JOIN customer ON record.customerId = customer.id " +
//                    "WHERE employee.id = ? AND employee.state = 1";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, ApplicationContext.CURRENT_EMP.getId()); // 设置 employee.id 参数
//            preparedStatement.setInt(2, ApplicationContext.CURRENT_EMP.getState()); // 设置 employee.state 参数
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                Map<String, Object> rowMap = new HashMap<>();
//                rowMap.put("id", resultSet.getInt("id"));
//                rowMap.put("cname", resultSet.getString("cname"));
//                rowMap.put("ename", resultSet.getString("ename"));
//                rowMap.put("rtype", resultSet.getString("rtype"));
//                rowMap.put("remark", resultSet.getString("remark"));
//                rowMap.put("createtime", resultSet.getTimestamp("createtime"));
//                resultList.add(rowMap);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            DBUtil.closeConnection(connection);
//        }
//        return resultList;
//    }

    public List<Record> getMyRecord() {
        String sql = "SELECT record.id, customer.cname, employee.ename, rtype, remark, record.createtime " +
                "FROM record INNER JOIN employee ON record.employeeId = employee.id " +
                "INNER JOIN customer ON record.customerId = customer.id " +
                "WHERE employee.id = ? AND employee.state = 1";
        List<Record> records = JdbcUtil.selectList(sql, Record.class, ApplicationContext.CURRENT_EMP.getId());
        records.forEach(System.out::println);
        return records;

    }

}
