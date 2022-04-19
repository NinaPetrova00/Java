package com.citb408.goods;

public class Engineer implements Provider {
    private double wagePerHour; //заплата на час
    private int hoursWorked; //изработени часове

    public Engineer(double wagePerHour, int hoursWorked) {
        this.wagePerHour = wagePerHour;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateIncome() {
        return this.hoursWorked*this.wagePerHour;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "wagePerHour=" + wagePerHour +
                ", hoursWorked=" + hoursWorked +
                '}';
    }
}
