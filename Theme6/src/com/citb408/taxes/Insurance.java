package com.citb408.taxes;

public class Insurance implements Valuable{ //застраховка
    private long id;
    private double value;

    public Insurance(long id, double value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
