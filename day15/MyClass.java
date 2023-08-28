package com.wnxy.day15;

public class MyClass {
    public void method1() {
        method2();
    }

    public void method2() {
        String test = null;
        System.out.println(test.length());
    }

    public void methodA() {
        double random = Math.random();
        System.out.println("random = " + random);

        if (random <= 0.3) {
            int i = 1 / 0;
        }
        if (random <= 0.6) {
            String str = null;
            System.out.println(str.length());
        }
        if (random <= 0.8) {
            int[] ints = new int[3];
            ints[10] = 100;
        } else {
            System.out.println("-----木有bug------");
        }
    }

    public void methodD() throws Exception {
        String className = "com.wnxy.day15.MyClass";
        Class<?> aClass = Class.forName(className);
    }

    public void methodE() {
        String className = "com.wnxy.day15.MyClass";
        try {
            Class<?> aClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
