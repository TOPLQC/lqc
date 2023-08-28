package com.wnxy.crm_v05.dao.impl;

import com.wnxy.crm_v05.dao.CustomerDao;
import com.wnxy.crm_v05.entity.Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerFileDaoImpl implements CustomerDao {
    private final String path = "C:\\ziyuan\\resource\\crm_v05\\customers.txt";
    List<Customer> customers = getCustomerFormFile();

    @Override
    public boolean deleteCustomerByIndex(int index) {
        if (index > customers.size()) {
            return false;
        }
        customers.remove(index);
        saveCustomers2File();
        return true;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveCustomers2File();

    }

    @Override
    public Customer selectCustomerByPhone(String phone) {
        Optional<Customer> optional = customers.stream()
                .filter(customer -> customer.getPhone().equals(phone))
                .findFirst();
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName) {
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
    public List<Customer> getCustomerFormFile() {
        System.out.println("开始读文件");
        List<Customer> customers = new ArrayList<>();
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

    private void saveCustomers2File() {
        //同步文件
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Customer customer : customers) {
                writer.write(customer.toString());
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public void deleteCustomerByName(String name) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getName().equals(name)) {
                iterator.remove();
            }
        }
        saveCustomers2File();
    }
}
