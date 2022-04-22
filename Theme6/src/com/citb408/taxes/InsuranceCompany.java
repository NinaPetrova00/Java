package com.citb408.taxes;

import java.util.ArrayList;
import java.util.List;

public class InsuranceCompany extends BusinessItem{
    private double rentCosts;
    private double salaryCosts;
    private List<Valuable> valuables;

    public InsuranceCompany(BusinessCategory businessCategory, double rentCosts, double salaryCosts) {
        super(businessCategory);
        this.rentCosts = rentCosts;
        this.salaryCosts = salaryCosts;
        this.valuables = new ArrayList<>();
    }

    public double getRentCosts() {
        return rentCosts;
    }

    public double getSalaryCosts() {
        return salaryCosts;
    }

    public List<Valuable> getValuables() {
        return valuables;
    }

    public void addValuable(Valuable valuable){
        this.valuables.add(valuable);
    }

    public double totalIncome(){
        double sum=0;
        for(Valuable valuable:this.valuables){
            sum+=valuable.getValue();
        }
        return sum;
    }

    public double totalCosts(){
        return this.rentCosts+this.salaryCosts;
    }

    @Override
    public double netProfit() {
        return this.profit()-this.profit()*0.10;
    }

    @Override
    public String toString() {
        return "InsuranceCompany{" +
                "rentCosts=" + rentCosts +
                ", salaryCosts=" + salaryCosts +
                ", valuables=" + valuables +
                '}';
    }
}
