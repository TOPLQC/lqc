package com.wnxy.day02;

import java.util.Scanner;

public class InputApp {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        fuZhi();
    }


    public static void fuZhi() {
        long a = scanner.nextInt();
        a += 5;
        System.out.println(a);
        a -= 5;
        System.out.println(a);
        a *= 10;
        System.out.println(a);
        a /= 10;
        System.out.println(a);
        a %= 8;
        System.out.println(a);
    }

//    private static void divide() {
//        System.out.println("请输入第一个数字");
//        int one = scanner.nextInt();
//
//        System.out.println("请输入第二个数字");
//        int tow = scanner.nextInt();
//
//        System.out.printf("%s %% %s =%s\n", one,tow ,one % tow);
//        System.out.printf("%s / %s =%s\n", one,tow,1.0 * one / tow);
//    }


//    public static void sum() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入第一个数字");
//        double one = scanner.nextDouble();
//
//        System.out.println("请输入第二个数字");
//        double tow = scanner.nextDouble();
//
//
//        System.out.printf("%s+%s=%s\n", one, tow, one + tow);
//        System.out.printf("%s-%s=%s\n", one, tow, one - tow);
//        System.out.printf("%s*%s=%s\n", one, tow, one * tow);
//        System.out.printf("%s/%s=%s\n", one, tow, one / tow);
//    }

//    public static void inputDemo() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("请输入你的名字：");
//        String name = scanner.next();
//
//        System.out.println("请输入你的年龄：");
//        int age = scanner.nextInt();
//
//        System.out.println(name);
//        System.out.println(age);
//        System.out.println(name + "，你好，你的年龄为：" + age + "岁");
//    }

}
