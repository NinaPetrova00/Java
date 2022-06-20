package com.citb408.PrintingMachine;

public class InsufficientPaperException extends Exception {
    private final int requiredPaper;
    private final int maxNumberOfPaper;

    public InsufficientPaperException(int requiredPaper, int maxNumberOfPaper) {
        this.requiredPaper = requiredPaper;
        this.maxNumberOfPaper = maxNumberOfPaper;
    }

    public int getRequiredPaper() {
        return requiredPaper;
    }

    public int getMaxNumberOfPaper() {
        return maxNumberOfPaper;
    }

    @Override
    public String toString() {
        return "InsufficientPaperException{" +
                "requiredPaper=" + requiredPaper +
                ", maxNumberOfPaper=" + maxNumberOfPaper +
                "} " + super.toString();
    }
}
