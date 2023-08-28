package com.wnxy.day13.setdemo;

import java.util.TreeSet;

public class MyClass {
    public static void main(String[] args) {
        treeSet();
    }

    public static void treeSet() {
        TreeSet<Book> ste = new TreeSet();
        ste.add(new Book(39d, "上海发明家", "super大猩猩"));
        ste.add(new Book(72d, "海王", "吃肉的狮子"));
        ste.add(new Book(38d, "长沙大奸商", "super小桀"));
        ste.add(new Book(36d, "时间管理大师", "呆湾人鱼"));

        ste.descendingSet().forEach(System.out::println);
    }


}
