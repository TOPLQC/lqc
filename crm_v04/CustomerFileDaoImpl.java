package com.wnxy.crm_v04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CustomerFileDaoImpl implements CustomerDao {
    final String path = "C:\\ziyuan\\resource\\crm_v05\\customers.txt";

    @Override
    public boolean deleteCustomerByIndex(int index) {
        return false;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public Customer selectCustomerByPhone(String phone) {
        return null;
    }

    @Override
    public ArrayList<Customer> getCustomerByFirstName(String firstName) {
        return null;
    }

    @Override
    //获得全部的客户
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //需要将lien转换为Customer对象
                Customer customer = new Customer(line);
                customers.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteCustomerByName(String name) {

    }
}
