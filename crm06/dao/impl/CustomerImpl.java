package com.wnxy.crm06.dao.impl;

import com.wnxy.crm06.dao.CustomerDao;
import com.wnxy.crm06.entity.Customer;
import com.wnxy.crm06.exception.DataRepeatException;
import com.wnxy.crm06.utils.JdbcUtil;

import java.util.List;

public class CustomerImpl implements CustomerDao {
    @Override
    public void insert(Customer customer) {
        Customer dbCustomer = selectByMobile(customer.getMobile());
        if (dbCustomer != null) {
            throw new DataRepeatException("电话号码已经存在，添加失败");
        }
        String sql = "insert into customer(cname, mobile, age, gender, education) value (?,?,?,?,?)";
        JdbcUtil.execute(sql, customer.getCname(),
                customer.getMobile(),
                customer.getAge(),
                customer.getGender(),
                customer.getEducation());
    }

    @Override
    public void deleteById(Integer id) {
        Customer cus = selectById(id);
        if (cus == null) {
            throw new DataRepeatException("账户不经存在，删除失败");
        }
        String sql = "update customer set state = 0 where id=?";
        JdbcUtil.execute(sql, id);
    }

    @Override
    public void updateMobile(Integer id, String mobile) {
        Customer cus = selectById(id);
        if (cus == null) {
            throw new DataRepeatException("账户不经存在，更新失败");
        }
        String sql = "update customer set mobile = ? where id = ? and state=1";
        JdbcUtil.execute(sql, mobile, id);
    }

    @Override
    public List<Customer> selectAll() {
        String sql = "select * from customer where state=1";
        return JdbcUtil.selectList(sql, Customer.class);
    }

    @Override
    public Customer selectByMobile(String mobile) {
        String sql = "select * from customer where mobile = ? and state=1";
        return JdbcUtil.selectOne(sql, Customer.class, mobile);
    }

    public Customer selectById(Integer id) {
        String sql = "select * from customer where id = ? and state=1";
        return JdbcUtil.selectOne(sql, Customer.class, id);
    }
}
