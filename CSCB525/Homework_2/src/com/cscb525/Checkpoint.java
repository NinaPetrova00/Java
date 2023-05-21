package com.cscb525;

import java.util.PriorityQueue;
import java.util.Queue;

public class Checkpoint {
    private String name;
    private Queue<Vehicle> vehicleQueue;

    public Checkpoint(String name) {
        this.name = name;
        vehicleQueue = new PriorityQueue<>();
    }

    public Checkpoint(String name, Queue<Vehicle> vehicles) {
        this.name = name;
        this.vehicleQueue = vehicles;
    }

    public String getName() {
        return name;
    }

   void addVehicle(Vehicle v){
        vehicleQueue.offer(v);
   }

    public void passThrough(){
        if(!vehicleQueue.isEmpty()){
            Vehicle polled;
            while((polled=vehicleQueue.poll())!=null){
                System.out.println(polled);
            }
        }else{
            System.out.println("No vehicles at the checkpoint!");
        }
    }

    public void showVehicles(){
        if(!vehicleQueue.isEmpty()){
            System.out.println(vehicleQueue);
        }else{
            System.out.println("No vehicles at the checkpoint!");
        }
    }

    @Override
    public String toString() {
        return "Checkpoint{" +
                "name='" + name + '\'' +
                ", vehicleQueue=" + vehicleQueue +
                '}';
    }
}
