package com.citb408.building;

public class Premise { // Помещение в сграда
    private Building building;
    private double area;

    public Premise(Building building, double area) {
        this.building = building;
        this.area = area;
    }

    public Building getBuilding() {
        return building;
    }

    public double getArea() {
        return area;
    }

    public void capacity(){
        System.out.println("Premise capacity: " + this.area);
    }

    @Override
    public String toString() {
        return "Premise{" +
                "building=" + building +
                ", area=" + area +
                '}';
    }
}
