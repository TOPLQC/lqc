package com.wnxy.day11;

public class Application {
    public static void main(String[] args) {
        absTest();
    }

    public static void absTest() {
        AbstractDemo abs = new AbsTest();

        abs.cat();
        abs.dog();

    }
}
