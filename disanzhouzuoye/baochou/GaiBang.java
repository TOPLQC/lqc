package com.wnxy.disanzhouzuoye.baochou;

public class GaiBang extends Killer {
    public void hand18() {
        System.out.println("降龙十八掌，啪啪啪");
    }

    @Override
    public void kill() {
        hand18();
    }
}
