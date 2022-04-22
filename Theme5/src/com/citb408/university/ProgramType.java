package com.citb408.university;

public enum ProgramType {
    MAJOR(240),MINOR(120);

    private int numberOfCredits;

    ProgramType(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
}
