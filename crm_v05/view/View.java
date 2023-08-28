package com.wnxy.crm_v05.view;

import com.wnxy.crm_v05.dao.CustomerDao;
import com.wnxy.crm_v05.entity.Customer;
import com.wnxy.crm_v05.factory.DaoFactory;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {

    CustomerDao customerDao = DaoFactory.creatCustomerDao();
    Scanner scanner = new Scanner(System.in);
    Map<String, String> menuMap = new HashMap<>();

    {
        menuMap.put("显示全部客户", "showAllCustomer");
        menuMap.put("添加客户信息", "addCustomer");
        menuMap.put("根据姓氏查找客户", "selectCustomerByFirstName");
        menuMap.put("根据下标删除客户", "deleteCustomerByIndex");
        menuMap.put("根据名字删除客户", "deleteCustomerByName");
    }

    public void run() {
        System.out.println("欢迎使用本系统！");
        while (true) {
            showMenu();
            System.out.println("是否要继续？y/n");
            String flag = scanner.next();
            if (flag.equals("n")) {
                return;
            }
        }
    }


    @SneakyThrows
    private void showMenu() {
        String[] menus = new String[menuMap.size()];
        menuMap.keySet().toArray(menus);

        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%s、%s\n", i + 1, menus[i]);
        }
        int index = scanner.nextInt() - 1;
        if (index > menus.length - 1) {
            System.out.println("输入错误");
            return;
        }
        String methodName = menuMap.get(menus[index]);

        System.out.println(methodName);

        Method method = View.class.getDeclaredMethod(methodName);
        try {
            method.invoke(this);
        } catch (Exception ex) {
            System.out.println("操作失败，原因是" + ex.getMessage());
            ex.printStackTrace();
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
        String name = scanner.next();
        List<Customer> customerByFirstName = customerDao.getCustomerByFirstName(name);
        if (customerByFirstName.size() == 0) {
            System.out.println("没有符合的数据");
            return;
        }
        customerByFirstName.forEach(System.out::println);
    }

    private void addCustomer() {
        Customer customerInfo = getCustomerInfo();
        customerDao.addCustomer(customerInfo);


    }


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
        List<Customer> customers = customerDao.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

}
