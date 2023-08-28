package com.wnxy.book;

public class Book {
    private int id;
    private double price;
    private String bookName;
    private String author;
    private String bookType;

    public Book() {
    }

    public Book(int id, double price, String bookName, String author, String bookType) {
        this.id = id;
        this.price = price;
        this.bookName = bookName;
        this.author = author;
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", price=" + price +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", bookType='" + bookType + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
