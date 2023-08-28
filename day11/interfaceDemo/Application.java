package com.wnxy.day11.interfaceDemo;

public class Application {
    public static void main(String[] args) {
//        InterfaceDemoApplication interfaceDemoApplication = new InterfaceDemoApplication();
//        interfaceDemoApplication.ia();
//        interfaceDemoApplication.ib();
        printlnDemo();
    }

    public static void callDemo02() {
        IA ia = new InterfaceDemoApplication();
        demo2(ia);
    }

    public static void demo2(IA ia) {
        ia.ia();
    }

    public static void callDemo03() {
        ICalculate ic = new ICalculate() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a + b;
            }
        };
        demo03(ic);
    }

    public static void demo03(ICalculate ic) {
        int a = 10, b = 20;
        Integer res = ic.calculate(a, b);
        System.out.println(res);
    }

    public static void printlnDemo() {
        Println println = new Println();
        println.printlnSquare(8);
    }
}
