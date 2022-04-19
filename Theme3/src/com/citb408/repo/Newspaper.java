package com.citb408.repo;

public class Newspaper extends Document{
    private int numberOfArticles;

    public Newspaper() {
    }

    public Newspaper(String title, double size, String format, int numberOfArticles) {
        super(title, size, format);
        this.numberOfArticles = numberOfArticles;
    }

    public int getNumberOfArticles() {
        return numberOfArticles;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "numberOfArticles=" + numberOfArticles +
                "} " + super.toString();
    }
}
