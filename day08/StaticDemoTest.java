package com.wnxy.day08;

public class StaticDemoTest {
    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
        staticDemo.name = "lqc";
        StaticDemo staticDemo1 = new StaticDemo();
        staticDemo1.name = "wzy";
        StaticDemo.schoolName = "白马，万峰，达外";
        System.out.println("staticDemo.name = " + staticDemo.name);
        System.out.println("staticDemo1.name = " + staticDemo1.name);
        System.out.println("staticDemo1.schoolName = " + StaticDemo.schoolName);
    }
}
