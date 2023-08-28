package com.wnxy.day11.baochou;

import java.util.ArrayList;

public class Manager {
    public ArrayList<IThuger> thug() {
        IThuger thuger = new Monkey();
        IThuger thuger1 = new Dog();
        ArrayList<IThuger> list = new ArrayList<IThuger>();
        list.add(thuger1);
        list.add(thuger);
        return list;
    }
}
