package com.citb408.goods;

public class TaxiDriver extends RegisterProvider {
    private double pricePerKm;
    private double distance;

    public TaxiDriver(String type, String regNumber, double pricePerKm, double distance) {
        super(type, regNumber);
        this.pricePerKm = pricePerKm;
        this.distance = distance;
    }

    @Override
    public double calculateIncome() {
        return this.pricePerKm * this.distance;
    }

    @Override
    public String toString() {
        return "TaxiDriver{" +
                "pricePerKm=" + pricePerKm +
                ", distance=" + distance +
                "} " + super.toString();
    }
}
