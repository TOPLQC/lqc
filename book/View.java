package com.wnxy.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    BookDao bookDao = new BookDao();

    public void run() {
        System.out.println("欢迎使用本系统！");
//        int coutn = 0;
        while (true) {
//            if (coutn >= 3) {
//                System.out.println("使用次数已经超出限制");
//                return;
//            }
            showMenu();
//            coutn++;
            System.out.println("是否要继续？y/n");
            String option = scanner.next();
            if (!option.equalsIgnoreCase("y")) {
                System.out.println("欢迎下次再次使用");
                return;
            }
        }
    }

    private void showMenu() {
        String[] menus = {"显示全部书籍", "添加图书", "根据价格范围查询图书", "根据作者姓名删除图书  ", "根据图书名称模糊查找图书"};
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%s、%s\n", i + 1, menus[i]);
        }
        String option = scanner.next();
        switch (option) {
            case "1":
                showAllBook();
                break;
            case "2":
                addBook();
                break;
            case "3":
                selectBookByPriceRange();
                break;
            case "4":
                deleteBookByAuthor();
                break;
            case "5":
                fuzzySearchBook();

                break;
            default:
                System.out.println("输入错误");
                break;

        }
    }


    private Book getBookInfo() {
        Book book = new Book();

        System.out.print("请输入书本id：");
        book.setId(scanner.nextInt());

        System.out.print("请输入书名：");
        book.setBookName(scanner.next());

        System.out.print("请输入书本的作者：");
        book.setAuthor(scanner.next());

        System.out.print("请输入书本的价格：");
        book.setPrice(scanner.nextDouble());

        System.out.print("请输入书本的类型：");
        book.setBookType(scanner.next());

        return book;
    }

    private void addBook() {
        Book bookInfo = getBookInfo();
        bookDao.addBook(bookInfo);
        showAllBook();
    }

    private void fuzzySearchBook() {
        System.out.println("请输入需要查找的书籍字段");
        String name = scanner.next();

        ArrayList<Book> books = bookDao.fuzzySearchBook(name);
        if (books.size() == 0) {
            System.out.println("没有符合信息的书籍");
        }

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }

    private void deleteBookByAuthor() {
        System.out.println("请输入作者名字");
        String author = scanner.next();
        Boolean flag = bookDao.deleteBookByAuthor(author);

        if (flag) {
            System.out.println("书本删除成功");
            showAllBook();
            return;
        }

        System.out.println("没有找到相关的书本信息，删除失败");
//        if (books.size()==0){
//            System.out.println("没有查到相关作者的书籍");
//        }
//        Iterator<Book> iterator = books.iterator();
//        while (iterator.hasNext()){
//            Book book = iterator.next();
//            System.out.println(book);
//        }

    }


    private void selectBookByPriceRange() {
        System.out.println("请输要查找书本的最低价");
        Double minPrice = scanner.nextDouble();
        System.out.println("请输要查找书本的最高价（如果输入0，则会获取最低价之后的所有书籍信息）");
        Double maxPrice = scanner.nextDouble();

        if (maxPrice == 0) {
            maxPrice = Double.MAX_VALUE;
        }

        ArrayList<Book> books = bookDao.selectBookByPriceRange(minPrice, maxPrice);
        if (books.size() == 0) {
            System.out.println("没有符合条件的书籍");
            return;
        }

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }

    private void showAllBook() {
        ArrayList<Book> books = bookDao.getBooks();
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book next = iterator.next();
            System.out.println(next.toString());
        }
    }

}
