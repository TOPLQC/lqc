package com.wnxy.day04;

import java.util.Scanner;

public class WhileDemo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        getSum1();
    }

    public static void getSum1() {
        int i = 1, sum = 0;
        while (true) {
            sum += i;
            if (sum >= 1000) {
                break;
            }
            i++;

        }
        System.out.println(sum);
        System.out.println(i);
    }


    public static void whi() {
        int i = scanner.nextInt();
        int sum = 0;

        while (i <= 100) {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }

    public static void getSum() {
        System.out.println("请输入一个数，输入0时停止：");
        long num = scanner.nextLong();
        long sum = 0L;

        while (num != 0) {
            sum += num;
            System.out.println("请输入下一个数，输入0时停止：");
            num = scanner.nextLong();
        }
        System.out.println(sum);
    }
}
