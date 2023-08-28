package com.wnxy.day13.setdemo;

public class Book implements Comparable<Book> {
    private Double price;
    private String bookName;
    private String author;

    public Book(double price, String bookName, String author) {
        this.price = price;
        this.bookName = bookName;
        this.author = author;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
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


    @Override
    public int compareTo(Book o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }
}
