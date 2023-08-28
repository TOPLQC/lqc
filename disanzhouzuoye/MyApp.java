package com.wnxy.disanzhouzuoye;

public class MyApp {
    public static void main(String[] args) {

    }

    public static void demo01() {
        /**创建抽象类对象
         * 前面接触过，可以将任何一个子类对象看成是父类的身份
         * Animal animal=new Tiger();
         * 我们可以将任何一个老虎看成是动物，因为tiger是继承了Animal
         * 因此MuClass也继承了MyAbstractClass，所以我们可以将MyClass对象看成是所以我们可以将MyClass对象看成是MyAbstractClass*/
        MyAbstractClass myClass = new MyClass();
        myClass.normalMethod();
    }
}
