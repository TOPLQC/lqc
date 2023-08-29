package com.wnxy.day17;

import java.util.List;
import java.util.Optional;

public class MyClass {
    public static <T> void reverseArray(T[] array) {
        int i = 0, j = array.length - 1;
        for (; i < j; i++, j--) {
            T tamp = array[i];
            array[i] = array[j];
            array[j] = tamp;
        }
    }

    public static <T> Optional<T> firstItem(List<T> list) {
        Optional<T> first = list.stream()
                .findFirst();
        return first;
    }
}
