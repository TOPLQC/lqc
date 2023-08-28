package com.wnxy.disanzhouzuoye.interfacedemo;

public class MyClass extends BaseClass implements IA, IB {
    @Override
    public void methodA() {
        System.out.println("~~~methodA()~~~");
    }

    @Override
    public void methodB() {
        System.out.println("~~~methodB()~~~");
    }

    public void myMenthod() {
        System.out.println("~~~~~ 这是MyClass自己的方法myMethod ~~~~~");
    }
}
