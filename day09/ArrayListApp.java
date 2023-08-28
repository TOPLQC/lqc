package com.wnxy.day09;

import com.duoxiancheng.DuoXianCheng;

import java.util.ArrayList;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayListApp arrayListApp = new ArrayListApp();
        ArrayList arrayList = arrayListApp.createArrayList();
        arrayListApp.arrayListCircle(arrayList);

    }

    public ArrayList createArrayList() {
        ArrayList arrayList = new ArrayList();
        DuoXianCheng duoXianCheng = new DuoXianCheng();
        arrayList.add("lqc");
        arrayList.add(1893);
        arrayList.add(false);
        return arrayList;
    }


    public void arrayListCircle(ArrayList arrayList) {
        for (Object item : arrayList) {
            System.out.println(item);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Object object = arrayList.get(i);
            System.out.println(object);
        }
    }
}
