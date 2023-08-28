package com.wnxy.day04;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        demo03();
//        collectScore();
    }

    public static void demo03() {
        String name = "乐乐乐乐";
        int length = name.length();
        System.out.println(name + "的长度为：" + length);
        String next = scanner.next();

        if (name.equals(next)) {
            System.out.println("登陆成功了老六");
        } else {
            System.out.println("密码错误了臭傻逼！");
        }
    }


    public static void collectScore() {
        System.out.println("请输入考试人数");
        int count = scanner.nextInt();
        double[] sco = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.printf("请输入第%s位学员成绩\n", i + 1);
            sco[i] = scanner.nextDouble();
        }
        System.out.println(Arrays.toString(sco));
    }


    public static void demo02() {
        double[] scors = {86, 92, 72, 84, 66, 45, 39, 68, 55, 79, 12, 0};
        double min = scors[0];
        for (int i = 0; i < scors.length; i++) {
            if (min > scors[i]) {
                min = scors[i];
            }
            System.out.println(i);
        }

    }

    public static void demo01() {
        int[] nums = {11, 22, 33, -9, 8 - 73, 12, -7, 26, -25};
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                sum += nums[i];
            }
            if (nums[i] < 0) {
                count++;
            }
        }
        System.out.println("数组里的数字为：" + Arrays.toString(nums));
        System.out.println("正数和为：" + sum);
        System.out.println("负数的数量为：" + count);
    }


    public static void demo() {
        double[] sco = {20, 60, 80, 90, 70, 50, 60, 30, 40, 40, 80, 100};
        double sum = 0;
        for (int i = 0; i < sco.length; i++) {
            sum += sco[i];

        }
        System.out.println("sum=" + sum);
    }


    public static void test() {
        String[] names = {"lqc1", "lqc2", "lqc3", "lqc4"};
        System.out.println("当前有以下用户用户" + Arrays.toString(names));
        System.out.println("要修改第几个人的名字?");
        int i = scanner.nextInt();
        if (i > names.length || i <= 0) {
            System.out.println("输入的数字不存在");

        } else {
            System.out.println("请输入新的名字：");
            String name = scanner.next();
            names[i - 1] = name;
            System.out.println(Arrays.toString(names));
        }
    }
}

