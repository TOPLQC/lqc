package com.wnxy.day13.streamdemo;

import java.util.*;
import java.util.stream.Collectors;

public class MyApp {
    static ArrayList<User> users;

    static {
        users = new ArrayList<>();
        users = new ArrayList<>();
        users.add(new User("10000", "李逍遥", true, 18, "广东"));
        users.add(new User("10001", "赵灵儿", false, 16, "云南"));
        users.add(new User("10002", "李白", true, 50, "四川"));
        users.add(new User("10003", "杜甫", true, 54, "广东"));
        users.add(new User("10005", "张少华", false, 28, "广东"));


    }

    public static void main(String[] args) {
        demo08();
    }

    public static void demo10() {
        Optional<Integer> optional = users.stream()
                .map(User::getAge)
                .min(Comparator.reverseOrder());
        System.out.println(optional.get());
    }

    public static void demo09() {
        Optional<User> optional = users.stream()
                .min(Comparator.comparing(User::getAge));

        if (!optional.isPresent()) {
            System.out.println("傻逼，没人");
        }
        System.out.println(optional.get());
    }

    public static void demo08() {
        List<String> res = users.stream()
                .map(user -> String.format("%s (%s)", user.getName(), user.getSex() ? "男" : "女"))
                .collect(Collectors.toList());

        res.forEach(System.out::println);
    }

    public static void demo07() {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 6, 9, 8, 7, 4, 5, 2, 3, 6, 9, 8, 7, 1);
        list.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::print);
        System.out.println("\n-----------------------------------------");
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);
        System.out.println("\n-----------------------------------------");
        list.stream()
                .sorted()
                .forEach(System.out::print);


    }

    public static void demo06() {
        List<User> collect = users.stream()
                .sorted(Comparator.comparing(User::getId).reversed())
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public static void demo05() {
        List<User> collect = users.stream()
                .sorted(Comparator.comparing(user -> user.getAge()))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public static void demo04() {

    }

    public static void demo03() {
        MyClass myClass = new MyClass();
        myClass.a().a().b().c().d().b().c().d().a().e();
    }

    public static void demo02() {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "张老三", "李四", "赵六", "王五", "李四", "李白");

        long count = names.stream()
                .filter(name -> name.length() == 3)
                .count();
        System.out.println(count);
    }

    public static void demo01() {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "张老三", "李四", "赵六", "王五", "李四", "李白");

        Set<String> set = names.stream()
                .filter(name -> name.length() == 2)
                .filter(name -> name.startsWith("李"))
//                .forEach(System.out::println);
                .collect(Collectors.toSet());

        for (String s : set) {
            System.out.println("s = " + s);
        }

    }

}
