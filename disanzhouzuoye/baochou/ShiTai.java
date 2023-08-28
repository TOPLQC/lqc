package com.wnxy.disanzhouzuoye.baochou;

public class ShiTai extends Killer {
    public void liangjian() {
        System.out.println("倚天不出，谁与争锋");
    }

    @Override
    public void kill() {
        liangjian();
    }
}
