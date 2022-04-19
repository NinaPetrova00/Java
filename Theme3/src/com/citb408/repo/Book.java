package com.citb408.repo;

public class Book extends Document{
    private String isbn;
    private Author author;

    public Book() {
    }

    public Book(String title, double size, String format, String isbn, Author author) {
        super(title, size, format);
        this.isbn = isbn;
        this.author = author;
    }

    public Book(String isbn, Author author) {
        this.isbn = isbn;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author=" + author +
                "} " + super.toString();
    }

}
