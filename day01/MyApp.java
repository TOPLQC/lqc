package com.wnxy.day01;

import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        // 原始数组
        String[] person = {"鸡哥-绿尸寒-ctrl", "阿针-我的很大-你要忍一下", "罗汁翔-时间管理大师-群趴"};


        String[] newArray = new String[person.length + 1];
        System.arraycopy(person, 0, newArray, 0, person.length);
        // 添加新数据到新数组的最后一个位置

        while (true) {
            System.out.println("请输入要添加的嘤熊");
            String newPerson = new Scanner(System.in).next();
            if (newPerson.matches("[\\p{IsHan}A-Za-z0-9]+-[\\p{IsHan}A-Za-z0-9]+-[\\p{IsHan}A-Za-z0-9]+")) {
                newArray[newArray.length - 1] = newPerson;
                break;
            } else {
                System.out.println("输入格式不正确，请重新输入");
            }
        }

        // 输出新数组的内容
        for (String s : newArray) {
            System.out.println(s);
        }
    }
}