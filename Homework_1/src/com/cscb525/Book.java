package com.cscb525;

import java.util.Comparator;
import java.util.List;

public class Book {
    private String name;
    private int price;
    private BookType bookType;

    public Book() {
    }

    public Book(String name, int price, BookType bookType) {
        this.name = name;
        this.price = price;
        this.bookType = bookType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public static Comparator<Book> BookPrice = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {

            return Integer.compare(book1.price,book2.price);
        }
    };

    public static Comparator<Book> BookName = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {
           return book1.name.compareTo(book2.name);
        }
    };

    public static  Comparator<Book> BookType = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.bookType.compareTo(book2.bookType);
        }
    };

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", bookType=" + bookType +
                '}';
    }

}
