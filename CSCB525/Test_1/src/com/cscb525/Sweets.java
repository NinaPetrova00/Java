package com.cscb525;

import java.time.LocalDate;
import java.util.Comparator;

public class Sweets implements Comparable<Sweets> {
    private long regNumber;
    private String name;
    private LocalDate productionDate;
    private double productionPrice;
    private int producedQuantity;
private SweetsType sweetsType;

    public long getRegNumber() {
        return regNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public double getProductionPrice() {
        return productionPrice;
    }

    public int getProducedQuantity() {
        return producedQuantity;
    }

    public SweetsType getSweetsType() {
        return sweetsType;
    }

    public Sweets(long regNumber, String name, LocalDate productionDate, double productionPrice, int producedQuantity, SweetsType sweetsType) {
        this.regNumber = regNumber;
        this.name = name;
        this.productionDate = productionDate;
        this.productionPrice = productionPrice;
        this.producedQuantity = producedQuantity;
        this.sweetsType  = sweetsType;
    }

    @Override
    public int compareTo(Sweets o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Sweets{" +
                "regNumber=" + regNumber +
                ", name='" + name + '\'' +
                ", productionDate=" + productionDate +
                ", productionPrice=" + productionPrice +
                ", producedQuantity=" + producedQuantity +
                '}';
    }
}
