package com.wnxy.day13.streamdemo;

import java.util.ArrayList;
import java.util.Collections;

public class StreamDemo {
    public static void main(String[] args) {
        demo02();
    }

    public static void demo02() {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "lis", "wangwu", "xg", "xp", "pp", "gpw");
        list.stream()
                .filter(n -> n.length() == 2)
                .filter(n -> n.startsWith("x"))
                .forEach(System.out::println);
    }
}
