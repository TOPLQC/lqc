package com.wnxy.day05;

import java.util.Arrays;

public class FoEeachDemo {
    public static void main(String[] args) {
        demo01();
    }

    public static void demo01() {
        String[] names = {"张三丰", "张无忌", "小昭", "白眉鹰王", "金毛狮王", "周芷若", "赵敏"};
        for (String name : names) {
            name = name + "1";
//            System.out.println(name);
        }
        System.out.println(Arrays.toString(names));
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i] + "1";
//            System.out.println(names[i]);
        }
        System.out.println(Arrays.toString(names));
    }


    public static void demo02() {
        String source = "张三-李四-王五-赵六";
        String[] names = source.split("-");
        for (String name : names) {
            System.out.println(name);

        }
    }
}
