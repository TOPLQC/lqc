package com.wnxy.day11.println;

import java.util.function.Function;

public class Println {


    public void printlnSquare(int length, Function function) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                System.out.printf("%s  ", function.apply(i));
            }
            System.out.println();
        }
    }
}
