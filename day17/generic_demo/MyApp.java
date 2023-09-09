package com.wnxy.day17.generic_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApp {
    public static void main(String[] args) {
        demo04();
    }

    public static void demo04() {
        List<String> array2 = new ArrayList<>();
        array2.add("2");
        array2.add("3");
        array2.add("4");
        array2.add("5");
        array2.add("6");


        List<Integer> arr3 = new ArrayList<>();
        arr3.add(1);
        arr3.add(2);
        arr3.add(5);
        arr3.add(7);
        arr3.add(9);

        boolean compare = MyClass.compare(array2, array2);
        System.out.println(compare);
    }


    public static void demo03() {
        MyList<String> myList = new MyList<>();
        myList.add("com/wnxy/lqc");
        myList.add("xxx");
        myList.forEach(System.out::println);
        myList.remove(1);
    }

    public static void getFirst() {
        List<String> array2 = new ArrayList<>();
        array2.add("2");
        array2.add("3");
        array2.add("4");
        array2.add("5");
        array2.add("6");
        String s = MyClass.firstItem(array2);
        System.out.println(s);

        List<Integer> arr3 = new ArrayList<>();
        arr3.add(1);
        arr3.add(2);
        arr3.add(5);
        arr3.add(7);
        arr3.add(9);
        Integer integer = MyClass.firstItem(arr3);
        System.out.println(integer);
    }

    public static void callReverse() {
        Integer[] array1 = {3, 4, 5, 7, 8, 9, 10};
        MyClass.reverseArray(array1);
        System.out.println(Arrays.toString(array1));

        String[] array2 = {"23", "41", "51", "72", "855", "999", "1100"};
        MyClass.reverseArray(array2);
//        Optional<String> s = MyClass.firstItem(array2);
        System.out.println(Arrays.toString(array1));


    }

    public static void callSwapStudent() {
        Student student = new Student("com/wnxy/lqc", 88);
        Student student1 = new Student("ssc", 99);
        swapStudent(student, student1);

        System.out.println(student.toString());
        System.out.println(student1.toString());
    }


    public static void swapStudent(Student stu1, Student stu2) {
        Student temp = stu1;
        stu1 = stu2;
        stu2 = temp;
    }


    public static void callDemo() {
        int i = 13;
        demo01(i);
        System.out.println(i);
    }

    public static void demo01(int num) {
        num *= 2;
    }
}
