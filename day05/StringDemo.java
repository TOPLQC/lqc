package com.wnxy.day05;

public class StringDemo {
    public static void main(String[] args) {
        indexOf();
    }

    public static void indexOf() {
        String strName = "lqc-zhh-jui-opp-pxj-cnm-cc";
        String[] names = strName.split("-");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        int one = strName.indexOf("j");
        System.out.println("第一次出现的位置" + one);
        int tow = strName.indexOf("j", one + 1);
        System.out.println("第二次出现的位置：" + tow);
    }
}
