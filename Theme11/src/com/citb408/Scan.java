package com.citb408;

public class Scan implements Runnable {
    private String documentName;
    private int numberOfPages;
    private Thread thread;

    public Scan(String documentName, int numberOfPages) {
        this.documentName = documentName;
        this.numberOfPages = numberOfPages;
        thread = new Thread("Scan Thread");
        thread.start();
    }

    @Override
    public void run() {
        // в метода run трябва да преценим какво в нишката се прави
        for (int i = 1; i <= this.numberOfPages; i++) {
            System.out.println(Thread.currentThread().getName()+" " +this.documentName + " scanned " + i + " page.");
        }
    }
}
