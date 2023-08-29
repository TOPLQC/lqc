package com.wnxy.day17;

import lombok.SneakyThrows;

import java.io.File;

public class MyApp {
    public static void main(String[] args) {
        demo02();
    }

    @SneakyThrows
    public static void demo02() {
        String path = "D:\\test\\le\\123.txt";
        File file = new File(path);
        if (file.exists()) {
            System.out.println("文件已经存在");
            return;
        }
        String dirPath = file.getParent();
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        file.createNewFile();
        System.out.println("OK!");
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
