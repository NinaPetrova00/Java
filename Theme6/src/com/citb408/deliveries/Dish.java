package com.citb408.deliveries;

import java.util.ArrayList;
import java.util.List;

public class Dish extends DeliverableItem implements Eatable {
    private String name;
    private double price;
    private List<FoodStuff> foodStuffList;

    public Dish(DeliveryCategory deliveryCategory, String name, double price) {
        super(deliveryCategory);
        this.name = name;
        this.price = price;
        this.foodStuffList = new ArrayList<>();
    }


    public void addFoodProduct(FoodStuff foodStuff) {
        this.foodStuffList.add(foodStuff);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", foodStuffList=" + foodStuffList +
                "} " + super.toString();
    }
}
