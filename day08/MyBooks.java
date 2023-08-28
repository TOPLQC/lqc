package com.wnxy.day08;

public class MyBooks {
    public static void main(String[] args) {
        Book book = new Book();
        book.setPrice(25.32);
        book.setBookName("Java从入门到入土");
        book.setAuthor("Java之父马土丘");
        System.out.println("book = " + book);
        book = new Book(13.5, "MySQL从删库到跑路", "跑路大师麦跑跑");
        System.out.println("book = " + book);
    }

}
