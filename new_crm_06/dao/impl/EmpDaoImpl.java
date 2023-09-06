package com.wnxy.new_crm_06.dao.impl;

import com.wnxy.new_crm_06.ApplicationContext;
import com.wnxy.new_crm_06.dao.EmpDao;
import com.wnxy.new_crm_06.entity.Employee;
import com.wnxy.new_crm_06.exception.DataRepeatException;
import com.wnxy.new_crm_06.utils.JdbcUtil;

import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public Employee selectByAccount(String account) {
        String sql = "select * from employee where account = ? and state=1";
        return JdbcUtil.selectOne(sql, Employee.class, account);
    }

    @Override
    public List<Employee> selectAllEmp() {
        String sql = "select * from employee where state=1";
        return JdbcUtil.selectList(sql, Employee.class);
    }

    @Override
    public void addEmp(Employee employee) {
        Employee emp = selectByAccount(employee.getAccount());
        if (emp != null) {
            throw new DataRepeatException("账户已经存在，添加失败");
        }
        String sql = "insert into employee(account, password, ename) VALUES (?,?,?)";
        JdbcUtil.execute(sql, employee.getAccount(),
                employee.getPassword(),
                employee.getEname());
    }

    @Override
    public void deleteEmp(Integer id) {
        Employee emp = selectEmpById(id);
        if (emp == null) {
            throw new DataRepeatException("账户不经存在，删除失败");
        }
        if (emp.getAccount().equalsIgnoreCase(ApplicationContext.CURRENT_EMP.getAccount())) {
            throw new DataRepeatException("这是你自己的账户，无法删除");
        }
        String sql = "update employee set state = 0 where id=?";
        JdbcUtil.execute(sql, id);

    }

    public Employee selectEmpById(Integer id) {
        String sql = "select * from employee where state=1 and id = ?";
        Employee employee = JdbcUtil.selectOne(sql, Employee.class, id);
        return employee;
    }
}
