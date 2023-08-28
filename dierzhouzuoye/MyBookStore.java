package com.wnxy.dierzhouzuoye;

import java.util.Scanner;

public class MyBookStore {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        callCollectBooks();
    }

    public static void callCollectBook() {

        collectBook().showBook();
    }

    public static void callCollectBooks() {
        Book[] books = collectBooks();
        for (Book book : books) {
            book.showBook();
            System.out.println();
        }
    }

    public static Book collectBook() {
        Book book = new Book();
        System.out.println("请输入书本id");
        book.id = scanner.nextInt();
        System.out.println("请输入书本名字");
        book.title = scanner.next();
        System.out.println("请输入书本价格");
        book.price = scanner.nextDouble();
        System.out.println("请输入书本的作者");
        book.author = scanner.next();
        System.out.println("请输入书本类型：1为历史，2为科学，3为时政，4为科普，5为故事");
        book.type = scanner.nextInt();
        return book;
    }


    public static Book[] collectBooks() {
        System.out.println("请输入有多少本书");
        int count = scanner.nextInt();
        Book[] books = new Book[count];
        for (int i = 0; i < count; i++) {
            System.out.printf("~~~收集第%s本书的信息~~~\n", i + 1);
            books[i] = collectBook();
        }
        return books;
    }

}
