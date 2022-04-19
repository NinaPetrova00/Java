package com.citb408.shops;

import java.math.BigDecimal;

public class FlowersShop {
    private int numberOfFlowers;
    private BigDecimal price;

    public FlowersShop(int numberOfFlowers, BigDecimal price) {
        this.numberOfFlowers = numberOfFlowers;
        this.price = price;
    }

    public int getNumberOfFlowers() {
        return numberOfFlowers;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void sellFlowers(int numberOfFlowers) {
        this.numberOfFlowers -= numberOfFlowers;
    }

    public BigDecimal profit() {
        return this.price.multiply(BigDecimal.valueOf(this.numberOfFlowers));
    }

    public boolean isFirstShopMoreProfitable(FlowersShop flowersShop) {
        if (this.profit().compareTo(flowersShop.profit()) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FlowersShop{" +
                "numberOfFlowers=" + numberOfFlowers +
                ", price=" + price +
                '}';
    }
}
