package com.cscb525;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Pod Igoto", 30, BookType.ROMAN);
        Book book2 = new Book("Geracite", 25, BookType.POVEST);
        Book book3 = new Book("Zvukove", 20, BookType.STIHOSBIRKA);
        Book book4 = new Book("Nova zemya", 30, BookType.ROMAN);

        List<Book> bookList = new ArrayList<>(10);
        bookList.add(book1);
        bookList.add(book2);

        System.out.println(bookList);

        Bookstore bookstore = new Bookstore("Pirin",150,bookList);

        /* 1. Add book in the bookstore*/
        bookstore.addBook(book3);
        bookstore.addBook(book4);
        System.out.println("--------Task 1--------");
        System.out.println(bookstore.toString());

        /* 2. Remove book from the list*/
        bookstore.removeBook(book1);
        System.out.println("--------Task 2--------");
        System.out.println(bookstore.toString());

        /* 3.Show all books in reversed order*/
        System.out.println("--------Task 3--------");
        bookstore.reversedOrderBooks();

        /* 5. Sort books by price in asc order*/
        System.out.println("--------Task 5--------");
        bookstore.sortBooksByPrice();
        bookstore.showBooks();

        /* 6. Sort books by name in desc order*/
        System.out.println("--------Task 6--------");
        bookstore.sortBooksByName();
        bookstore.showBooks();


        /* 7. Sort books by type and by price in desc order*/
        System.out.println("--------Task 7--------");
        bookstore.sortBooksByTypeAndByPrice();
        bookstore.showBooks();


        /* 8. Return the last book in the booklist sorted by name*/
        System.out.println("--------Task 8--------");
        System.out.println(bookstore.lastBook());
    }
}
