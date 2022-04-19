package com.citb408.repo;

public class Repo {  //Хранилище за дигитални документи
    private double maxSize;
    private int numberOfDocuments;
    private double currentSize;

    public Repo(double maxSize, int numberOfDocuments, double currentSize) {
        this.maxSize = maxSize;
        this.numberOfDocuments = numberOfDocuments;
        this.currentSize = currentSize;
    }

    public double getMaxSize() {
        return maxSize;
    }

    public int getNumberOfDocuments() {
        return numberOfDocuments;
    }

    public double getCurrentSize() {
        return currentSize;
    }

    public void uploadDocument(Document document) {
        if (maxSize - currentSize >= document.getSize()) {
            this.currentSize += document.getSize();
            this.numberOfDocuments++;
            System.out.println(document.getTitle() + " is uploaded!");
        } else {
            System.out.println("Not enough space!");
        }
    }

    @Override
    public String toString() {
        return "Repo{" +
                "maxSize=" + maxSize +
                ", numberOfDocuments=" + numberOfDocuments +
                ", currentSize=" + currentSize +
                '}';
    }
}
