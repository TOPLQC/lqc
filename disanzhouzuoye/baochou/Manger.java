package com.wnxy.disanzhouzuoye.baochou;

import java.util.ArrayList;

public class Manger {
    public ArrayList<Killer> zhaoRen() {
        ArrayList<Killer> list = new ArrayList<Killer>();
        ShiTai shiTai = new ShiTai();
        list.add(shiTai);
        //ArrayList中每个元素的类型是killer，killer是ShiTai，GaiBang的父亲
        GaiBang gaiBang = new GaiBang();
        list.add(gaiBang);
        return list;
    }
}
