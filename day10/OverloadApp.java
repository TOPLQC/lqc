package com.wnxy.day10;

public class OverloadApp {
    public static void main(String[] args) {
        OverloadApp overloadApp = new OverloadApp();
        Integer sum = overloadApp.add(1, 2, 3, 4, 5, 6, 7,
                8, 9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19, 20, 21, 22, 23, 24,
                25, 26, 27, 28, 29, 30);
        System.out.println("sum = " + sum);
    }

    public Integer add(Integer... numbs) {
        int sum = 0;
        for (Integer numb : numbs) {
            sum += numb;
        }
        return sum;
    }
}
