package com.citb408.taxes;

public enum BusinessCategory {
    TAXI_DRIVER(1000), HAIRDRESSER(1200);

    private double patentTax;

    BusinessCategory(double patentTax) {
        this.patentTax = patentTax;
    }

    public double getPatentTax() {
        return patentTax;
    }

    public void setPatentTax(double patentTax) {
        this.patentTax = patentTax;
    }
}
