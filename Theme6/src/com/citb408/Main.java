package com.citb408;

import com.citb408.deliveries.*;

public class Main {

    public static void main(String[] args) {
        FoodStuff tomato = new FoodStuff(DeliveryCategory.CAT2,"Tomato", false, FoodType.VEGETABLE);
        FoodStuff chickenMeat = new FoodStuff(DeliveryCategory.CAT3,"Chicken", false, FoodType.MEAT);
        FoodStuff garlic = new FoodStuff(DeliveryCategory.CAT1,"Garlic", true, FoodType.VEGETABLE);

        System.out.println(tomato);
        System.out.println(chickenMeat);
        System.out.println(garlic);
        garlic.eat();
        System.out.println("Is " + chickenMeat + " delivered " + chickenMeat.isDelivered(200));

        Dish pasta = new Dish(DeliveryCategory.CAT1,"Pasta", 15);
        pasta.addFoodProduct(tomato);
        pasta.addFoodProduct(chickenMeat);
        pasta.addFoodProduct(garlic);

        System.out.println(pasta);
        pasta.eat();
        System.out.println("Is " + pasta + " delivered " + pasta.isDelivered(9));


        Shop shop = new Shop("Billa");
        shop.addFoodStuff(tomato);
        shop.addFoodStuff(chickenMeat);

        Restaurant restaurant = new Restaurant("Happy");
        restaurant.addDish(pasta);
    }
}
