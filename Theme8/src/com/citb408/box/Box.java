package com.citb408.box;

public class Box {
    private double dim1;
    private double dim2;
    private double dim3;

    public Box(double dim1, double dim2, double dim3) {
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.dim3 = dim3;
    }
    public double getDim1() {
        return dim1;
    }

    public double getDim2() {
        return dim2;
    }

    public double getDim3() {
        return dim3;
    }
    public double volume() {
        return this.dim1 * this.dim2 * this.dim3;
    }

    public void increaseDimensions(double increasePercentage) throws IllegalArgumentException {
        if (increasePercentage < 0 || increasePercentage > 100) {
            throw new IllegalArgumentException("The value has to be between 0 and 100!");
        } else {
            this.dim1 += this.dim1 * increasePercentage / 100;
            this.dim2 += this.dim2 * increasePercentage / 100;
            this.dim3 += this.dim3 * increasePercentage / 100;
        }
    }

    public void optionalIncreaseDimensions(double increasePercentage, double volumeNumber) {
        if (this.volume() <= volumeNumber) {
            try {
                increaseDimensions(increasePercentage);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "dim1=" + dim1 +
                ", dim2=" + dim2 +
                ", dim3=" + dim3 +
                '}';
    }
}
