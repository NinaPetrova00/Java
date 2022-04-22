package com.citb408.deliveries;

public enum DeliveryCategory {
    CAT1(20),CAT2(40),CAT3(60);

    private double maxTime;

    DeliveryCategory(double maxTime) {
        this.maxTime = maxTime;
    }

    public double getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(double maxTime) {
        this.maxTime = maxTime;
    }
}
