package com.wnxy.day11.baochou;

public class Dog implements IThuger {

    public void dog() {
        System.out.println("狗崽队");
    }

    @Override
    public void thug() {
        dog();
    }
}
