package com.cscb525;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle1 = new Vehicle(900,false);
        Vehicle vehicle2 = new Vehicle(1500,true);
        Vehicle vehicle3 = new Vehicle(1300,false);
        Vehicle vehicle4 = new Vehicle( 2500,true);

        Checkpoint checkpoint1 = new Checkpoint("Makaza");

        System.out.println("--- Checkpoint 1 show vehicles ---");
        checkpoint1.showVehicles();

        /*checkpoint1.addVehicle(vehicle1);
        checkpoint1.addVehicle(vehicle2);
        checkpoint1.addVehicle(vehicle3);
        checkpoint1.addVehicle(vehicle4);*/

        System.out.println("--- Checkpoint 1 show vehicles ---");
        checkpoint1.showVehicles();
        System.out.println("--- Checkpoint 1 pass through ---");
        checkpoint1.passThrough();

        Queue<Vehicle> vehicleQueue = new PriorityQueue<>(Vehicle.vehicleType.thenComparing(Vehicle.vehicleWeight.reversed()).reversed());
        vehicleQueue.add(vehicle1);
        vehicleQueue.add(vehicle2);
        vehicleQueue.add(vehicle3);
        vehicleQueue.add(vehicle4);

        Checkpoint checkpoint2 = new Checkpoint("Kulata",vehicleQueue);
        System.out.println("--- Checkpoint 2 show vehicles ---");
        checkpoint2.showVehicles();
        System.out.println("--- Checkpoint 2 pass through ---");
        checkpoint2.passThrough();
    }
}
