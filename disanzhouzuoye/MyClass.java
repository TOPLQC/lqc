package com.wnxy.disanzhouzuoye;

public class MyClass extends MyAbstractClass {
    @Override
    public void abstractMethod() {
        System.out.println("mycalss实现的抽象类方法");
    }

    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }
}
