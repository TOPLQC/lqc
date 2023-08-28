package com.wnxy.crm_v05.dao.impl;

import com.wnxy.crm_v05.dao.CustomerDao;
import com.wnxy.crm_v05.entity.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerFileDaoImpl implements CustomerDao {
    private final String path = "C:\\ziyuan\\resource\\crm_v05\\customers.txt";

    @Override
    public boolean deleteCustomerByIndex(int index) {

        return false;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public Customer selectCustomerByPhone(String phone) {
        try {
            List<Customer> customers = Files.lines(Paths.get(path))
                    .map(Customer::new)
                    .collect(Collectors.toList());

            return customers.stream()
                    .filter(customer -> customer.getPhone().equals(phone))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName) {
//        ArrayList<Customer> customers = new ArrayList<>();
//        List<Customer> temp = new ArrayList<>();
//        try (FileReader fileReader = new FileReader(path)) {
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                Customer customer = new Customer(line);
//                customers.add(customer);
//                List<Customer> collect = customers.stream()
//                        .filter(customer1 -> customer1.getName().startsWith(firstName))
//                        .collect(Collectors.toList());
//                temp = collect;
//            }
//        } catch (Exception e) {
//        }
//        return temp;
        try {
            List<Customer> customers = Files.lines(Paths.get(path))
                    .map(Customer::new)
                    .collect(Collectors.toList());

            List<Customer> filteredCustomers = customers.stream()
                    .filter(customer -> customer.getName().startsWith(firstName))
                    .collect(Collectors.toList());
            return filteredCustomers;

        } catch (Exception e) {
            throw new RuntimeException("读取文件出错！", e);
        }
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
        return customers;
    }

    @Override
    public void deleteCustomerByName(String name) {

    }
}
