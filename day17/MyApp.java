package com.wnxy.day17;

import lombok.SneakyThrows;

import java.io.File;

public class MyApp {
    public static void main(String[] args) {
        demo03();
    }

    public static void demo03() {
        String path = "D:\\Ace Combat 7 Skies Unknown";
        File file = new File(path);
        showFiles(file, "|---");
    }

    public static void showFiles(File file, String pre) {
        File[] files = file.listFiles();
        for (File child : files) {
            System.out.println(pre + " " + child.getName());
            if (child.isDirectory()) {
                showFiles(child, pre + "---");
            }
        }
    }


    public static void traverseFile(File file, String pre) {
        if (file.isDirectory()) {
            System.out.println(pre + "文件夹:" + file.getName());
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    traverseFile(f, "|---"); // 递归遍历子文件夹
                }
            }
        } else {
            System.out.println(pre + "---" + "文件：" + file.getName());
        }
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
