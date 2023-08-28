//package com.wnxy.crm_v05.dao.impl;
//
//import com.wnxy.crm_v05.dao.CustomerDao;
//import com.wnxy.crm_v05.entity.Customer;
//import com.wnxy.crm_v05.exception.DataRepeatException;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Iterator;
//
//public class CustomerDaoImpl implements CustomerDao {
//    private ArrayList<Customer> customers;
//
//    {
//
//        customers = new ArrayList<>();
//        {
//            customers.add(new Customer("王婧", false, "1301234567", "广东"));
//            customers.add(new Customer("张三", true, "1311234567", "广东"));
//            customers.add(new Customer("李四", true, "1381234567", "山西"));
//            customers.add(new Customer("任我行", true, "1381234569", "陕西"));
//            customers.add(new Customer("王母娘娘", false, "1391234568", "福建"));
//            customers.add(new Customer("玉皇大帝", true, "1311234566", "福建"));
//            customers.add(new Customer("孙悟空", true, "13033339999", "海南"));
//        }
//        ;
//    }
//
//
//    public boolean deleteCustomerByIndex(int index) {
////        if (index < 0 || index >= customers.length) {
////            return false;
////        }
////        int newArrayIndex = 0;
////        Customer[] tempArray = new Customer[customers.length - 1];
////        for (int i = 0; i < customers.length; i++) {
////            if (i != index) {
////                tempArray[newArrayIndex] = customers[i];
////                newArrayIndex++;
////            }
////        }
////        customers = tempArray;
//        customers.remove(index);
//        return true;
//    }
//
//
//    public void addCustomer(Customer customer)  {
//        //判断电话号码是否重复
//        boolean exists = customers.stream()
//                .anyMatch(c -> c.getPhone().equals(customer.getPhone()));
//        if (exists == true) {
//            throw new DataRepeatException("电话号码已经存在");
//        }
//        customers.add(customer);
//    }
//
//
//    public Customer selectCustomerByPhone(String phone) {
//        for (Customer customer : customers) {
//            if (customer.getPhone().equals(phone)) {
//                return customer;
//            }
//        }
//        return null;
//    }
//
//    public ArrayList<Customer> getCustomerByFirstName(String firstName) {
////        Customer[] tempArray = new Customer[customers.length];
////        int count = 0;
//        ArrayList<Customer> temp = new ArrayList<>();
//        for (Customer customer : this.customers) {
//            if (customer.getName().startsWith(firstName)) {
//
//                temp.add(customer);
//                //               tempArray[count] = customer;
////                count++;
//            }
//        }
//
////        Customer[] resultArray = new Customer[count];
////        for (int i = 0; i < count; i++) {
////            resultArray[i] = tempArray[i];
////        }
//        return temp;
//
//    }
//
//    public ArrayList<Customer> getCustomers() {
//        Comparator<Customer>
//                comparator = (other1, other2) -> other1.getName().compareTo(other2.getName());
//        Collections.sort(customers, comparator);
//        return customers;
//    }
//
//    public void deleteCustomerByName(String name) {
//        Iterator<Customer> iterator = customers.iterator();
//        while (iterator.hasNext()) {
//            Customer customer = iterator.next();
//            if (customer.getName().equals(name)) {
//                iterator.remove();
//            }
//        }
//    }
//}
