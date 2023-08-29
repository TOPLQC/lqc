package com.wnxy.day17;

import java.io.File;

public class MyApp {
    public static void main(String[] args) {
        demo01();
    }

    public static void demo01() {
        String path = "C:\\ziyuan\\resource\\compny\\company.txt";

        File file = new File(path);
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.isDirectory() = " + file.isDirectory());
        System.out.println("file.getParent() = " + file.getParent());
        System.out.println("file.getPath() = " + file.getPath());
    }
}
