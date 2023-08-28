package com.wnxy.dierzhouzuoye;

import java.util.ArrayList;

public class ClassWork {
    public static void main(String[] args) {
        ClassWork classWork = new ClassWork();
        ArrayList<Integer> arrayList = classWork.demo01();
        classWork.demo02(arrayList);
    }

    public ArrayList<Integer> demo01() {
        ArrayList<Integer> arrayList = new ArrayList();

        arrayList.add(new Integer(55));
        arrayList.add(new Integer(55));
        arrayList.add(new Integer(55));
        arrayList.add(new Integer(55));
        arrayList.add(new Integer(55));
        arrayList.add(new Integer(553));
        arrayList.add(new Integer(55));
        arrayList.add(new Integer(55));

        return arrayList;
    }

    public void demo02(ArrayList<Integer> nums) {
        Integer sum = 0;
        for (Integer obj : nums) {
            sum += obj;
        }
        System.out.println(sum);
    }
}
