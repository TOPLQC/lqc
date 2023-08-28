package com.wnxy.day11.baochou;

public class Monkey implements IThuger {

    public void stick() {
        System.out.println("猴子的救兵");
    }

    @Override
    public void thug() {
        stick();
    }
}
