package com.citb408;

public class RaceThread implements Runnable {
    private CarRace carRace;
    private String name;

    public RaceThread(CarRace carRace, String name) {
        this.carRace = carRace;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= this.carRace.getLaps(); i++) {
            System.out.println(this.name + " lap: " + i);

            if (i == this.carRace.getLaps()) {
                System.out.println(this.name + " finished!");
            }
        }
    }
}
