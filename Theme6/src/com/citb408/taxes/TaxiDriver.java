package com.citb408.taxes;

public class TaxiDriver extends BusinessItem{
    private double fuelCosts;
    private double vehicleCosts;
    private double distance;
    private double pricePerKm;

    public TaxiDriver(BusinessCategory businessCategory, double fuelCosts, double vehicleCosts, double distance, double pricePerKm) {
        super(businessCategory);
        this.fuelCosts = fuelCosts;
        this.vehicleCosts = vehicleCosts;
        this.distance = distance;
        this.pricePerKm = pricePerKm;
    }

    public double totalIncome(){
        return this.pricePerKm*this.distance;
    }

    public double totalCosts(){
        return this.fuelCosts+this.vehicleCosts;
    }
}
