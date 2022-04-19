package com.citb408.building;

public class Building {
    private double area;

    public Building(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Building{" +
                "area=" + area +
                '}';
    }
}
