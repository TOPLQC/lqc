package com.wnxy.day17.generic_demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MyList<T> extends ArrayList<T> {
    DateTimeFormatter dfe = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public boolean add(T t) {
        System.out.printf("%s进行了一次添加\n", dfe.format(LocalDateTime.now()));
        return super.add(t);
    }

    @Override
    public T remove(int index) {
        System.out.printf("%s进行了一次删除\n", dfe.format(LocalDateTime.now()));
        return super.remove(index);
    }
}
