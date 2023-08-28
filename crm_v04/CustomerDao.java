package com.wnxy.crm_v04;

import java.util.ArrayList;

public interface CustomerDao {
    boolean deleteCustomerByIndex(int index);

    void addCustomer(Customer customer);

    Customer selectCustomerByPhone(String phone);

    ArrayList<Customer> getCustomerByFirstName(String firstName);

    ArrayList<Customer> getCustomers();

    void deleteCustomerByName(String name);
}
