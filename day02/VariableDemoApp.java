package com.wnxy.day02;

public class VariableDemoApp {
    public static void main(String[] args) {
        initializeVariable();
        initialize2();

    }


    public static void initializeVariable() {

        int number = 100;

        double price = 3.5;

        char sex = '男';

        String name = "你好，hello world";

        System.out.println(number);
        System.out.println(price);
        System.out.println(sex);
        System.out.println(name);
    }


    public static void initialize2() {
        String subject1 = "你好",
                subject2 = "hello",
                subject3 = "world",
                subject4 = "bye";

        System.out.println(subject1);
        System.out.println(subject2);
        System.out.println(subject3);
        System.out.println(subject4);

    }

//    public static void declare() {
//        int number;
//        number = 100;
//
//        double price;
//        price = 3.5;
//
//        char sex;
//        sex = '男';
//
//        String name;
//
//        name = "你好，hello world";
//        System.out.println(number);
//        System.out.println(price);
//        System.out.println(sex);
//        System.out.println(name);
//    }
}
