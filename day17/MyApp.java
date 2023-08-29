package com.wnxy.day17;

public class MyApp {
    public static void main(String[] args) {
        callSwapStudent();
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
