package com.wnxy.new_crm_06.dao;

import com.wnxy.new_crm_06.entity.Employee;

import java.util.List;

public interface EmpDao {
    //根据登录名查找员工
    Employee selectByAccount(String account);

    //查询全部的员工
    List<Employee> selectAllEmp();

    //添加员工
    void addEmp(Employee employee);

    void deleteEmp(Integer id);

    Employee selectEmpById(Integer id);
}
