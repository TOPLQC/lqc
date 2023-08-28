package com.wnxy.day11.baochou;

public class Ethan extends Person implements IThuger {
    @Override
    public void thug() {
        System.out.println("投西，强人锁男，van游戏");
    }

    @Override
    public void age() {
        System.out.println("25");
    }
}
