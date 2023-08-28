package com.wnxy.day06;

import java.util.Arrays;
import java.util.Scanner;

public class CRM01App {
    static String[] customers = {"王婧", "苏小雨", "唐纯莉", "王璐苑", "姜藤椒", "姜子牙", "唐骏", "张三"};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    public static void run() {
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

    public static void showMenu() {
        System.out.println("请选择需要的功能");
        System.out.println("1、查询所有用户");
        System.out.println("2、增加一个用户");
        System.out.println("3、根据姓氏查找用户");
        System.out.println("4、根据姓名删除用户");
        String attion = scanner.next();

        switch (attion) {
            case "1":
                selecAll();
                break;
            case "2":
                addCustom();
                break;
            case "3":
                selectBySurName();
                break;
            case "4":
                deleteCustomByName();
                break;
            default:
                System.out.println("输入的操作错误！请重新输入");
                break;
        }
    }

    public static void selecAll() {
        for (int i = 0; i < customers.length; i++) {
            System.out.printf("%s、%s\n", i + 1, customers[i]);
        }
    }

    public static void selectBySurName() {
        int count = 0;
        System.out.println("请输入要查找的用户姓氏");
        String surName = scanner.next();
        for (String customer : customers) {
            if (customer.startsWith(surName)) {
                count++;
                System.out.printf("%s、%s\n", count, customer);
            }
        }
        if (count == 0) {
            System.out.println("没有找到符合条件的用户");
        }
    }

    public static void addCustom() {
        System.out.println("请输入要添加的客户");
        String name = scanner.next();
        for (String customer : customers) {
            if (customer.equals(name)) {
                System.out.println("有同名的用户，无法输入");
                return;
            }
        }
        String[] tamp = Arrays.copyOf(customers, customers.length + 1);
        tamp[tamp.length - 1] = name;
        customers = tamp;
        System.out.println("添加成功");
        selecAll();
    }

    public static void deleteCustomByName() {
        System.out.println("请输入要删除的客户的姓名");
        String name = scanner.next();
        int index = 0;
        String[] temp = new String[customers.length];
        for (String customer : customers) {
            if (!customer.equals(name)) {
                temp[index] = customer;
                index++;
            }
        }
        if (index == customers.length) {
            System.out.println("没找到需要删除的客户");
        } else {
            customers = Arrays.copyOf(temp, index);
            System.out.println(name + "删除成功！");
            selecAll();
        }
    }
}
