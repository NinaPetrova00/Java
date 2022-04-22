package com.citb408.deliveries;

public class FoodStuff extends DeliverableItem implements Eatable {
    private String name;
    private boolean isSpicy;
    private FoodType foodType;

    public FoodStuff(DeliveryCategory deliveryCategory, String name, boolean isSpicy, FoodType foodType) {
        super(deliveryCategory);
        this.name = name;
        this.isSpicy = isSpicy;
        this.foodType = foodType;
    }
    @Override
    public void eat() {
        Eatable.super.eat();
        System.out.println((isSpicy ? "But is" : " And is not") + " Spicy!!!");
    }

    @Override
    public String toString() {
        return "FoodStuff{" +
                "name='" + name + '\'' +
                ", isSpicy=" + isSpicy +
                ", foodType=" + foodType +
                "} " + super.toString();
    }
}
