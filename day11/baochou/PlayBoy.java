package com.wnxy.day11.baochou;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayBoy {
    public static void main(String[] args) {
        Manager manager = new Manager();
        ArrayList<IThuger> list = manager.thug();

        Iterator<IThuger> iterator = list.iterator();
        while (iterator.hasNext()) {
            IThuger thuger = iterator.next();
            thuger.thug();

        }


    }
}
