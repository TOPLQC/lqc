package com.wnxy.day13.mapdemo;

import com.wnxy.day13.setdemo.Book;

public class MyBook extends Book {
    private String isbn;


    public MyBook() {
    }

    public MyBook(double price, String bookName, String author, String isbn) {
        super(price, bookName, author);
        this.isbn = isbn;
    }

    public MyBook(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + this.getPrice() +
                ", bookName='" + this.getBookName() + '\'' +
                ", author='" + this.getAuthor() + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
