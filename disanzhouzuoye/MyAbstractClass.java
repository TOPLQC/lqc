package com.wnxy.disanzhouzuoye;

public abstract class MyAbstractClass {
    // abstract :抽象类
    //如果需要将一个类定义为抽象类，必须class关键字之前添加abstract
    public String name;

    public void normalMethod() {
        System.out.println("这是一个抽象类中的普通方法");
    }

    //声明一个抽象类方法，抽象类方法只有声明，不要实现，实现逻辑在子类中完成

    public abstract void abstractMethod();

    public abstract Integer add(Integer a, Integer b);
}
