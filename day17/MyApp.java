package com.wnxy.day17;

import java.util.Arrays;

public class MyApp {
    public static void main(String[] args) {
        demo03();
    }

    public static void demo03() {
        MyList<String> myList = new MyList<>();
        myList.add("lqc");
        myList.add("xxx");
        myList.forEach(System.out::println);
        myList.remove(1);
    }

    public static void callReverse() {
        Integer[] array1 = {3, 4, 5, 7, 8, 9, 10};
        MyClass.reverseArray(array1);
        System.out.println(Arrays.toString(array1));

        String[] array2 = {"23", "41", "51", "72", "855", "999", "1100"};
        MyClass.reverseArray(array2);
        System.out.println(Arrays.toString(array2));
    }

    public static void callSwapStudent() {
        Student student = new Student("lqc", 88);
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
