package com.citb408.goods;

public class Vehicle extends Goods {
    private double materialsExpenses;
    private double salaryExpenses;

    public Vehicle(double overcharge, double materialsExpenses, double salaryExpenses) {
        super(overcharge);
        this.materialsExpenses = materialsExpenses;
        this.salaryExpenses = salaryExpenses;
    }

    @Override
    public double productionPrice() {
        return this.materialsExpenses + this.salaryExpenses;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "materialsExpenses=" + materialsExpenses +
                ", salaryExpenses=" + salaryExpenses +
                "} " + super.toString();
    }
}
