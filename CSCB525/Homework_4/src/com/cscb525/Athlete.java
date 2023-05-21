package com.cscb525;

public class Athlete {
    private String name;

    public Athlete(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                '}';
    }
}
