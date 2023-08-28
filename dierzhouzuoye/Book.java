package com.wnxy.dierzhouzuoye;

public class Book {
    public int id; //id
    public String title;//名字
    public double price; //价格
    public String author;//作者
    public int type; //类型

    public void showBook() {
        System.out.println("书本id：" + id);
        System.out.println("书本名称：" + title);
        System.out.println("书本价格：" + price);
        System.out.println("书本作者：" + author);
        System.out.println("书本类型：" + type);
    }
}
