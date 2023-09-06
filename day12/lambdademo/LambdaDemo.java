package com.wnxy.day12.lambdademo;

public class LambdaDemo {
    public static void main(String[] args) {
        demo05();
    }

    public static void demo01() {
        IA ia = (Integer a, Integer b) -> {
            int sum = a + b;
            return sum;
        };

        System.out.println(ia.add(5, 6));
    }

    public static void demo05() {
        IA iaa = (Integer a, Integer b) -> {
            int sum = a * b;
            return sum;
        };
        System.out.println(iaa.add(5, 6));
    }

    public static void demo02() {
        IB ib = (a, b) -> System.out.printf("%s*%s=%s\n", a, b, a * b);
        ib.add(50, 100);
    }

    public static void demo03() {

    }

}