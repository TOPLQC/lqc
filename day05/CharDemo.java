package com.wnxy.day05;

import java.util.Scanner;

public class CharDemo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        tongJi();
//        char ziFi = 'z';
//        char ziFi2 = '9';
//        int i = ziFi;
//        int j = ziFi2;
//        ziFi = 122;
//        ziFi2 = 987;
//        System.out.println(i);
//        System.out.println(j);
//        System.out.println(ziFi);
//        System.out.println(ziFi2);
//        System.out.println((char) 115500);
    }

    public static void yanZheng() {
        char i = '1';
        if (i > '0' && i < '9') {
            System.out.println(i);
        }
    }

    public static void tongJi() {
        String source = "abc123ABC__++==";
        char[] litters = source.toCharArray();
        int daXie = 0, xiaoXie = 0, shuZi = 0;
        for (char litter : litters) {
            if (litter >= '0' && litter <= '9') {
                shuZi++;
            }
            if (litter >= 'a' && litter <= 'z') {
                xiaoXie++;
            }
            if (litter >= 'A' && litter <= 'Z') {
                daXie++;
            }
        }
        System.out.println("大写" + daXie);
        System.out.println("小写" + xiaoXie);
        System.out.println("数字" + shuZi);
        System.out.println("其他" + (litters.length - daXie - xiaoXie - shuZi));
    }
}