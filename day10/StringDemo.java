package com.wnxy.day10;

public class StringDemo {

    public static void main(String[] args) {
        System.out.println("demo04() = " + demo04(3));
//        String srt1 = new String("abc");
//        String str2 = "abc";
//
//        System.out.println(srt1 == str2);
//        System.out.println(srt1.equals(str2));
    }

    public static void demo02() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                continue;
            }
            sum += i;

        }
        System.out.println(sum);
    }

    public static void demo03() {
        int i = 10;
        int sum = 0;
        sum = i++ + ++i;
        System.out.println(sum);
        System.out.println("i = " + i);
    }

    public static Long demo04(long i) {

        long amass = 0;
        if (i == 0 && i == 1) {
            return 1L;
        }
        for (long j = i; j > 0; j--) {
            amass += i * (j);
        }
        return amass;
    }
}