package com.wnxy.day07;

import java.util.Scanner;

public class MyClass {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        student1();
    }

    public static void student1() {
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(90);
        stu.setSex(true);
        stu.setPhone("110");
        stu.introdce();
        int sum = stu.add(155197348, 702656384);
        System.out.println("\nsum=" + sum);
    }

    public static void callReturnStudent2() {
        returnStudent2().introdce();
    }

    public static Student returnStudent2() {
        Student stu = new Student();
        System.out.println("请输入姓名");
        stu.setName(scanner.next());
        System.out.println("请输入性别");
        stu.setSex(scanner.next().equals("1"));
        System.out.println("请输入年龄");
//        stu.age = scanner.nextInt();
        stu.setAge(scanner.nextInt());
        System.out.println("请输入电话");
        stu.setPhone(scanner.next());
        stu.introdce();
        return stu;
    }
}
