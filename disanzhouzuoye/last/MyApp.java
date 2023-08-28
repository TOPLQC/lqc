package com.wnxy.disanzhouzuoye.last;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyApp {
    public static void main(String[] args) {
        demo02();
    }

    public static void demo02() {
        List<Student> stus = new ArrayList<>();
        Collections.addAll(stus,
                new Student("tom", 18, 70),
                new Student("peter", 19, 80),
                new Student("alice", 15, 90)
        );
        Comparator<Student> comparator = (stu1, stu2) -> stu1.getWeight().compareTo(stu2.getWeight());
        Collections.sort(stus, comparator);
        System.out.println(stus);

    }

}

