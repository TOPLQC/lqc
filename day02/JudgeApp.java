package com.wnxy.day02;

import java.util.Scanner;

public class JudgeApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        showCourse();
//        judgeScore();
//        judgeZero();
    }

    public static void showCourse() {
        System.out.println("请输入要查看的日期");
        int weekDay = scanner.nextInt();

        switch (weekDay) {
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("今天是星期" + weekDay + "上晚自习");
                break;
            case 5:
                System.out.println("今天是星期" + weekDay + "不上晚自习");
                break;
            case 6:
                System.out.println("今天是星期" + weekDay + "自习+考试，不上晚自习");
                break;
            case 7:
                System.out.println("今天是星期日" + weekDay + "休息");
                break;

            default:
                System.out.println("mmp,输入错了，臭傻逼");
                break;

        }

    }
//    public static void judgeScore() {
//        double score = 60;
//        if (score >= 90) {
//            System.out.println("成绩优秀");
//        } else if (score >= 80) {
//            System.out.println("成绩良好");
//        } else if (score >= 60) {
//            System.out.println("成绩及格");
//        } else {
//            System.out.println("成绩不及格");
//        }
//    }

//    public static void judgeZero() {
//        int num = 99;
//        if (num > 0) {
//            System.out.println("这个数大于0");
//        } else if (num < 0) {
//            System.out.println("这个数小于0");
//        } else {
//            System.out.println("这个数为0");
//        }
//    }

//    public static void judgeDemo() {
//        System.out.println("请输入年龄：");
//        int age = new Scanner(System.in).nextInt();
//        if (age >= 18 && age <= 120) {
//            System.out.println("这是一个成年人");
//        } else if (age >= 120) {
//            System.out.println("这是一个死人");
//        } else
//            System.out.println("这是一个未成年人");
//
//        System.out.println("结束");
//    }
}
