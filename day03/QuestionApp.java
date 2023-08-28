package com.wnxy.day03;

import java.util.Scanner;

public class QuestionApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        demo03();
    }

    public static void demo03() {
        System.out.println("请输入一个正整数");
        int a = scanner.nextInt();
        String num = "";
        int sum = 0;

        for (int i = 1; i <= a; i++) {
            sum += i;
            num = num + i;
            if (i < a) {
                num += "+";
            }
        }

        System.out.printf("%s=%s", num, sum);
    }


    public static void demo02() {
        int sum = 0;
        String sum1 = "";

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum++;
                sum1 = sum1 + " " + i;
            }

        }
        System.out.println("总数是：" + sum);
        System.out.println("它们分别是：" + sum1);
    }


    public static void demo1() {
        System.out.println("请输入两个不相同的正整数，且第二个数要大于第一个数：");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        String tip = "输入错误！！！";
        int sum = 0;
        if ((num1 > 0 && num2 > 0) && num2 > num1) {
            for (int i = num1; i <= num2; i++) {
                sum += i;
                tip = "ok";
            }
        }
        System.out.println(sum);
        System.out.println(tip);
    }


    public static void sum1() {
        int num1 = 0;

        for (int i = 99; i >= 81; i = i - 2) {
            ++num1;
            System.out.printf("%s * %s = %s\n", i, num1, i * num1);
        }
    }

    public static void sum2() {

        for (int i = 99, j = 1; i >= 81; i -= 2, j++) {
            System.out.printf("%s * %s = %s\n", i, j, i * j);
        }
    }


    public static void sum() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            System.out.println(i);
        }
        System.out.println(sum);
    }


    public static void forDemo() {

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s、%s\n", i, "广州蜗牛学院");
//            System.out.println(i + "、广州蜗牛学院");
        }
    }

    public static void lyear() {
        System.out.println("请输入一个年份");
        int year = scanner.nextInt();
        String res = "不是闰年";

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            res = "是闰年";
        }
        System.out.println(res);
    }


    public static void remains() {
        System.out.println("请输入一个整数");
        int num1 = scanner.nextInt();
        int res = num1 % 3;
        int res1 = num1 % 5;
        String res3 = "这不是一个3或5的倍数";

        if (res == 0 || res1 == 0) {
            res3 = "这是一个3或5的倍数";
        }
        System.out.println(res3);

    }


    public static void tree() {
        System.out.println("请输入一个整数");
        int num1 = scanner.nextInt();
        String res = "no";

        if (num1 > 99 && num1 < 1000) {
            res = "yes";
        }
        System.out.printf("%s%s三位数", num1, res);
    }


//    public static void bool(){
//        System.out.println("请输入两个整数：");
//        int num1 = scanner.nextInt();
//        int num2 = scanner.nextInt();
//
//        boolean res= (num1!=num2);
//
//        if (res){
//            System.out.println("这两个数字不相同");
//        }else {
//            System.out.println("这两个数字相同");
//        }
//
//    }


//    public static void max() {
//        int max;
//
//        System.out.println("请输入三个整数：");
//        int num1 = scanner.nextInt();
//        int num2 = scanner.nextInt();
//        int num3 = scanner.nextInt();
//
//        max = num1 > num2 ? num1 : num2;
//        max = max > num3 ? max : num3;
//
//        System.out.println("最大值是"+max);
//
//    }
}
