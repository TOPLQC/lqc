package com.wnxy.disanzhouzuoye.disantian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Application {
    static {
        List<Student> stus = new ArrayList<>();
        Collections.addAll(stus,
                new Student("tom", 18, 70),
                new Student("peter", 19, 80),
                new Student("alice", 15, 40),
                new Student("liza", 15, 190),
                new Student("kolo", 15, 88)
        );
        Predicate<Student> predicate = student -> student.getWeight() > 80;
        stus.removeIf(predicate);
        System.out.println("stus = " + stus);
    }

    public static void main(String[] args) {
    }

}
