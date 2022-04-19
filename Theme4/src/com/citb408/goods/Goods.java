package com.citb408.goods;

import com.citb408.figures.Increasable;

public abstract class Goods implements ItemForSale, Increasable {
    private double overcharge; //надценка

    public Goods(double overcharge) {
        this.overcharge = overcharge;
    }

    @Override
    public double sellingPrice() {
        return this.productionPrice() + this.productionPrice() * (this.overcharge / 100);
    }

    @Override
    public void increase(double number) {
        this.overcharge += number;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "overcharge=" + overcharge +
                '}';
    }
}
