package com.wnxy.crm_v05.dao;

import com.wnxy.crm_v05.entity.Customer;

import java.util.List;

public interface CustomerDao {
    boolean deleteCustomerByIndex(int index);

    void addCustomer(Customer customer);

    Customer selectCustomerByPhone(String phone);

    List<Customer> getCustomerByFirstName(String firstName);

    List<Customer> getCustomerFormFile();

    List<Customer> getAllCustomers();

    void deleteCustomerByName(String name);
}
