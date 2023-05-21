package com.cscb525;

public class Coach {
    private String name;
    private int experienceYears;

    public Coach(String name, int experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }
}
