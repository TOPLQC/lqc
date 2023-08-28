package com.wnxy.crm_v03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {


    CustomerDao customerDao = new CustomerDao();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("欢迎使用本系统！");
//        int coutn = 0;
        while (true) {
//            if (coutn >= 3) {
//                System.out.println("使用次数已经超出限制");
//                return;
//            }
            showMenu();
//            coutn++;
            System.out.println("是否要继续？y/n");
            String option = scanner.next();
            if (!option.equalsIgnoreCase("y")) {
                System.out.println("欢迎下次再次使用");
                return;
            }
        }
    }

    private void showMenu() {
        String[] menus = {"显示全部客户", "添加客户信息", "根据姓氏查找客户", "根据下标删除客户", "根据名字删除客户"};
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%s、%s\n", i + 1, menus[i]);
        }
        String option = scanner.next();
        switch (option) {
            case "1":
                showAllCustomer();
                break;
            case "2":
                addCustomer();
                break;
            case "3":
                selectCustomerByFirstName();
                break;
            case "4":
                deleteCustomerByIndex();
                break;
            case "5":
                deleteCustomerByName();
                break;
            default:
                System.out.println("输入错误");
                break;

        }
    }

    private void deleteCustomerByName() {
        showAllCustomer();
        System.out.println("请输入要删除的用户名字");
        customerDao.deleteCustomerByName(scanner.next());
        showAllCustomer();
    }

    private void deleteCustomerByIndex() {
        showAllCustomer();
        System.out.println("请输入要删除第几个客户");
        boolean flag = customerDao.deleteCustomerByIndex(scanner.nextInt() - 1);
        if (!flag) {
            System.out.println("输入错误");
            return;
        }
        showAllCustomer();
        System.out.println("客户信息删除成功");
    }

    private void selectCustomerByFirstName() {
        System.out.print("请输入客户姓氏：");
        ArrayList<Customer> customerByFirstName = customerDao.getCustomerByFirstName(scanner.next());
        if (customerByFirstName.size() == 0) {
            System.out.println("没有符合的数据");
            return;
        }
        System.out.println(customerByFirstName.toArray().toString());
    }

    private void addCustomer() {
        Customer customerInfo = getCustomerInfo();
        Customer customer = customerDao.selectCustomerByPhone(customerInfo.getPhone());

        if (customer == null) {
            customerDao.addCustomer(customerInfo);
            System.out.println("添加客户信息成功");
        } else {
            System.out.println("已存在相同的电话号码，添加失败");
        }
        showAllCustomer();
    }
//        Customer customerInfo = getCustomerInfo();
//        Customer customer = customerDao.selectCustomerByPhone(getCustomerInfo().getPhone());
//
//
//        if (customer == null) {
//            customerDao.addCustomer(customerInfo);
//            System.out.println("添加客户信息成功");
//            return;
//        }
//        System.out.println("已存在相同的电话号码，添加失败");

    private Customer getCustomerInfo() {
        Customer customer = new Customer();

        System.out.print("请输入客户姓名：");
        customer.setName(scanner.next());

        System.out.print("请输入客户性别（1.男/2.女）：");
        customer.setSex(scanner.next().equals("1"));

        System.out.print("请输入客户电话号码：");
        customer.setPhone(scanner.next());

        System.out.print("请输入客户所在地：");
        customer.setProvince(scanner.next());

        return customer;
    }

    private void showAllCustomer() {
        List<Customer> customers = customerDao.getCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

}
