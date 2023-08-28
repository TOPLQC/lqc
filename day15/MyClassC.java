package com.wnxy.day15;

public class MyClassC {
    public void someMethod() {
        try {
            Class.forName("aaaa");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
