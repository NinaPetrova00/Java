package com.citb408.repo;

public class Novel extends Book{
    private String novelAbstract;

    public Novel() {
    }

    public Novel(String title, double size, String format, String isbn, Author author, String novelAbstract) {
        super(title, size, format, isbn, author);
        this.novelAbstract = novelAbstract;
    }

    public String getNovelAbstract() {
        return novelAbstract;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "novelAbstract='" + novelAbstract + '\'' +
                "} " + super.toString();
    }
}
