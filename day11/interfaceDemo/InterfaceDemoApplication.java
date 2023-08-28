package com.wnxy.day11.interfaceDemo;

public class InterfaceDemoApplication implements IA, IB {
    public static void main(String[] args) {

    }

    @Override
    public void ia() {
        System.out.println("IA");
    }

    @Override
    public void ib() {
        System.out.println("IB");
    }
}
