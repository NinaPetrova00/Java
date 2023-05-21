package com.cscb525;

import java.util.Comparator;

public class Vehicle implements Comparator<Vehicle>{
    private Integer weight;
    private boolean isEmergencyVehicle;

    public Vehicle(Integer weight, boolean isEmergencyVehicle) {
        this.weight = weight;
        this.isEmergencyVehicle = isEmergencyVehicle;
    }

    public Integer getWeight() {
        return weight;
    }

    public boolean isEmergencyVehicle() {
        return isEmergencyVehicle;
    }

    @Override
    public int compare(Vehicle vehicle1, Vehicle vehicle2) {
        return Boolean.compare(vehicle1.isEmergencyVehicle,vehicle2.isEmergencyVehicle);
    }
    public static Comparator<Vehicle> vehicleType = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle vehicle1, Vehicle vehicle2) {
            return Boolean.compare(vehicle1.isEmergencyVehicle,vehicle2.isEmergencyVehicle);
        }
    };

    public static Comparator<Vehicle> vehicleWeight = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle vehicle1, Vehicle vehicle2) {
            return vehicle1.weight.compareTo(vehicle2.weight);
        }
    };

    @Override
    public String toString() {
        return "Vehicle{" +
                "weight=" + weight +
                ", isEmergencyVehicle=" + isEmergencyVehicle +
                '}';
    }
}
