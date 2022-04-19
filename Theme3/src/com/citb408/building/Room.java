package com.citb408.building;

public class Room extends Premise{
    private int numberOfBeds;

    public Room(Building building, double area, int numberOfBeds) {
        super(building, area);
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    @Override
    public void capacity() {
        super.capacity();
        System.out.println("Room capacity " + this.numberOfBeds);
    }

    @Override
    public String toString() {
        return "Room{" +
                "numberOfBeds=" + numberOfBeds +
                "} " + super.toString();
    }
}
