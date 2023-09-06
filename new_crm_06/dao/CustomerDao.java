package com.wnxy.new_crm_06.dao;

import com.wnxy.new_crm_06.entity.Customer;

import java.util.List;

public interface CustomerDao {
    //添加客户
    void insert(Customer customer);

    //删除用户
    void deleteById(Integer id);

    //修改客户联系方式
    void updateMobile(Integer id, String mobile);

    //显示全部客户
    List<Customer> selectAll();

    //根据电话查询客户
    Customer selectByMobile(String mobile);
}
