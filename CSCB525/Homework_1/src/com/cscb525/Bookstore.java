package com.cscb525;

import java.util.*;

public class Bookstore {
    private String address;
    private int area;
    List<Book> bookList;

    public Bookstore() {
    }

    public Bookstore(String address, int area, List<Book> bookList) {
        this.address = address;
        this.area = area;
        this.bookList = bookList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    /* 1. Add book in the bookstore*/
    public void addBook(Book book){
        bookList.add(book);
    }

    public void addBooks(List<Book> books){
        bookList.addAll(books);
    }

    /* 2. Remove book from the list*/
    public void removeBook(Book book){
        if(bookList.contains(book)){
            bookList.remove(book);
        }else{
            System.out.println("This book does not exist!");
        }
    }

    /* 3.Show all books in reversed order*/
    public void reversedOrderBooks(){
        if(!bookList.isEmpty()){
            ListIterator<Book> bookListIterator = bookList.listIterator(bookList.size());

            while(bookListIterator.hasPrevious()){
                System.out.println(bookListIterator.previous()+", ");
            }
        }else{
            System.out.println("Empty book list!");
        }
    }

    /* 5. Sort books by price in asc order*/
    public void sortBooksByPrice(){
        Collections.sort(bookList, Book.BookPrice);
    }

    /* 6. Sort books by name in desc order*/
    public void sortBooksByName(){
        Collections.sort(bookList, Book.BookName.reversed());
    }

    /* 7. Sort books by type and by price in desc order*/
    public void sortBooksByTypeAndByPrice(){
        Collections.sort(bookList,Book.BookType.thenComparing(Book.BookPrice.reversed()));
    }

    /* 8. Return the last book in the booklist sorted by name*/
    public Book lastBook(){
       return bookList.get(bookList.size() -1);
    }

    public void showBooks(){
        if(!bookList.isEmpty()){
           Iterator<Book> bookIterator = bookList.iterator();

           while(bookIterator.hasNext()){
               System.out.println(bookIterator.next() + ", ");
           }
        }else{
            System.out.println("Empty book list!");
        }
    }

    @Override
    public String toString() {
        return "Bookstore{" +
                "address=" + address +
                ", area=" + area +
                ", bookList=" + bookList +
                '}';
    }
}
