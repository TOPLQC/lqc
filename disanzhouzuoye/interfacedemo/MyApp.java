package com.wnxy.disanzhouzuoye.interfacedemo;

public class MyApp {
    public static void main(String[] args) {

    }

    public static void demo02(IA ia) {
        ia.methodA();
    }

    public static void callDemo02() {
        //创建接口实例=穿件衣额实现了接口目标接口类的对象，并将其当前身份视为接口
        //（和抽象类一样，接口不可以直接new）
        //调用方法
        IA ia = new MyClass();
        demo02(ia);
        MyClass myClass = new MyClass();
        demo02(myClass);
    }

    //演示匿名内部类
    public static void demo03(ICalculate iCalculate) {
        int a = 5, b = 6;
        Integer result = iCalculate.calculate(5, 6);
        System.out.println(result);
    }

    public static void callDemo03() {
        ICalculate iCalculate = new ICalculate() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a + b;
            }
        };
        demo03(iCalculate);
        iCalculate = new ICalculate() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a - b;
            }
        };
        demo03(iCalculate);
    }
}
