package com.wnxy.book;

import java.util.ArrayList;
import java.util.Iterator;

public class BookDao {
    ArrayList<Book> books;

    {

        books = new ArrayList<>();
        {
            books.add(new Book(1, 15.2, "故事会", "无名", "故事"));
            books.add(new Book(2, 18.9, "世界未解之谜", "王涛", "故事"));
            books.add(new Book(5, 15.5, "如何用用没用的技能解决没用的问题", "逗比", "技能"));
            books.add(new Book(4, 22.5, "Java从入门到入土", "Java之父马土丘", "知识"));
            books.add(new Book(4, 22.5, "Java从入门到入土", "Java之父马土丘", "知识"));
            books.add(new Book(8, 33.8, "MySQL从删库到跑路", "MySQL boy", "知识"));
            books.add(new Book(10, 66, "向后进攻", "麦跑跑", "技能"));
            books.add(new Book(10, 66, "向后进攻", "麦跑跑", "技能"));
            books.add(new Book(9, 19999, "智商税", "三句话", "超级技能"));
        }
    }


    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> selectBookByPriceRange(Double minPrice, Double maxPrice) {
        ArrayList<Book> resBooks = new ArrayList<>();
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getPrice() >= minPrice && book.getPrice() < maxPrice) {
                resBooks.add(book);
            }
        }
        return resBooks;
    }

    public Boolean deleteBookByAuthor(String author) {
        Boolean flag = false;
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();

            if (book.getAuthor().equals(author)) {
                iterator.remove();
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public ArrayList<Book> fuzzySearchBook(String bookName) {
        ArrayList<Book> resBooks = new ArrayList<>();
        Iterator<Book> iterator = this.books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookName().contains(bookName)) {
                resBooks.add(book);
            }
        }

        return resBooks;
    }
}
