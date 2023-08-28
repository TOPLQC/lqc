package com.wnxy.day09;

import java.util.ArrayList;

public class TestArrayRemove {
    public static void main(String[] args) {
        Integer vl = 1;

        ArrayList arrayList = new ArrayList();
        arrayList.add(0, "shenmegui!");
        arrayList.add("sha");
        arrayList.add(123456);
        arrayList.add(1);
        arrayList.remove("sha");
        arrayList.remove(vl);
        for (Object o : arrayList) {

            System.out.println(o);
        }
    }


}

