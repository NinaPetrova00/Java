package com.citb408;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private int laps;
    private List<String> racers;

    public CarRace(int laps) {
        this.laps = laps;
        this.racers = new ArrayList<>();
    }

    public void addRacer(String name) {
        this.racers.add(name);
    }

    public int getLaps() {
        return laps;
    }

    public List<String> getRacers() {
        return racers;
    }

    public void startRace() {
        for (String name : this.racers) {
            Thread thread = new Thread(new RaceThread(this, name));
            thread.start();
        }
    }

    @Override
    public String toString() {
        return "CarRace{" +
                "laps=" + laps +
                ", racers=" + racers +
                '}';
    }
}
