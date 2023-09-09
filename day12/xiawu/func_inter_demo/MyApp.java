package com.wnxy.day12.xiawu.func_inter_demo;

import com.wnxy.disanzhouzuoye.last.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.*;

public class MyApp {
//    {
//        Function<Integer, Integer> function = num -> num * 2;
//        System.out.println(function.apply(9));
//    }
//
//    {
//        Consumer<Student> consumer = stu -> System.out.println(stu.getName() + "-" + stu.getAge() + "-" + stu.getWeight());
//        Student student = new Student("韩少云", 88, 1180);
//        consumer.accept(student);
//    }

    public static void main(String[] args) {
        demo06();
    }


    public static void demo05() {
        Function<Integer, Integer> staticMethod = MyClass::staticMethod;
        System.out.println(staticMethod.apply(8));
    }

    public static void demo06() {
        BiFunction<MyClass, Integer, Integer> method = MyClass::method;
        MyClass myClass = new MyClass();
        System.out.println(method.apply(myClass, 8));

    }

    public static void demo04() {
        ArrayList<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 4, 6, 8, 9, 5, 4, 7, 2, 10, 22, 33, 55, 66, 77, 88, 99);
        Predicate<Integer> predicate = num -> num % 2 == 0;

        nums.removeIf(predicate);
        System.out.println(nums);
    }

    public static void demo03() {
        Supplier<Student> supplier = () -> {
            Student student = new Student();
            student.setAge(18);
            student.setName("com/wnxy/lqc");
            student.setWeight(70);
            return student;
        };
        Student stu = supplier.get();
        System.out.println("stu = " + stu);
    }

    public void demo01() {
        Consumer<Integer> consumer = num -> System.out.println(num * 8);
        consumer.accept(8);
    }
}
