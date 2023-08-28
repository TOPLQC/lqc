package com.wnxy.day13.mapdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MyApp {
    public static void main(String[] args) {
        showAllBook01();
    }

    public static void showAllBook01() {
        Map<String, MyBook> bookMap = creatBookMap();
        for (Map.Entry<String, MyBook> entry : bookMap.entrySet()) {
            System.out.printf("kye=%s,value=%s\n", entry.getKey(), entry.getValue());

        }


    }

    public static void showAllBook02() {
        Map<String, MyBook> bookMap = creatBookMap();
        Set<String> keys = bookMap.keySet();
        for (String key : keys) {
            System.out.printf("kye=%s,value=%s\n", key, bookMap.get(key));
        }
    }

    public static void getBookByKey() {
        Map<String, MyBook> bookMap = creatBookMap();
        System.out.println("请输入书本的isbn码");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.next();
        if (!bookMap.containsKey(isbn)) {
            System.out.println("没找到你要的书");
            return;
        }
        MyBook myBook = bookMap.get(isbn);
        System.out.println(myBook);
    }

    //      ste.add(new Book(39d,"上海发明家","super大猩猩"));
//        ste.add(new Book(72d,"海王","吃肉的狮子"));
//        ste.add(new Book(38d,"长沙大奸商","super小桀"));
//        ste.add(new Book(36d,"时间管理大师","呆湾人鱼"));
    public static Map<String, MyBook> creatBookMap() {
        HashMap<String, MyBook> map = new HashMap<>();
        MyBook myBook = new MyBook(39d, "上海发明家", "super大猩猩", "001");
        map.put(myBook.getIsbn(), myBook);
        myBook = new MyBook(86.5d, "海王", "吃肉的狮子", "023");
        map.put(myBook.getIsbn(), myBook);
        myBook = new MyBook(3960.9d, "长沙大奸商", "super小桀", "0018");
        map.put(myBook.getIsbn(), myBook);
        myBook = new MyBook(89.9d, "时间管理大师", "呆湾人鱼", "8896");
        map.put(myBook.getIsbn(), myBook);
        return map;
    }
}
