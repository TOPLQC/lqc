package com.wnxy.day15;

public class MyApp {
    public static void main(String[] args) {
        method3();
        System.out.println("123556");
    }

    public static void method3() {
        try {
            MyClass myClass = new MyClass();
            myClass.methodA();
        } catch (NullPointerException e) {
            System.out.println("异常类型是NullPointerException，原因是" + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("异常类型是ArithmeticException，原因是" + e.getMessage());
        } catch (Exception e) {
            System.out.printf("异常类型是%s，原因是%s", e.getClass().getSimpleName(), e.getMessage());
        } finally {
            System.out.println("\n傻逼");
        }

    }

    public static void method04() {
        MyClass myClass = new MyClass();
        try {
            myClass.methodD();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void method05() {
        MyClass myClass = new MyClass();
        myClass.methodE();
    }
}
