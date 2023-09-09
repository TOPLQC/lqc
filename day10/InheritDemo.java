package com.wnxy.day10;

public class InheritDemo {
    public static void main(String[] args) {
        domo02();
    }

    public static void domo02() {
        Child child = new Child();
    }

    public static void demo01() {
        Policeman policeman = new Policeman();
        policeman.name = "com/wnxy/lqc";
        policeman.age = 11;
        policeman.sex = false;
        policeman.rank = "一级警司";
        String policemanInfo = policeman.getPolicemanInfo();
        System.out.println("policemanInfo = " + policemanInfo);
    }

    public void demo03(double... num) {

    }
}
