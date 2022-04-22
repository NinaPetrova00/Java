package com.citb408.taxes;

public abstract class BusinessItem implements Costs,Income,Profit{
    private BusinessCategory businessCategory;

    public BusinessItem(BusinessCategory businessCategory) {
        this.businessCategory = businessCategory;
    }

    @Override
    public double profit() {
        return this.totalIncome()-this.totalCosts();
    }

    @Override
    public double netProfit() {
        return this.profit() - this.businessCategory.getPatentTax();
    }
}
