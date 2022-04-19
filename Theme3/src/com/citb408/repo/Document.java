package com.citb408.repo;

public class Document {
    private String title;
    private double size;
    private String format;

    public Document() {
    }

    public Document(String title, double size, String format) {
        this.title = title;
        this.size = size;
        this.format = format;
    }

    public String getTitle() {
        return title;
    }

    public double getSize() {
        return size;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", size=" + size +
                ", format='" + format + '\'' +
                '}';
    }
}
