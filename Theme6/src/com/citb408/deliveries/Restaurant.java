package com.citb408.deliveries;

import com.citb408.deliveries.Dish;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Dish> dishes;

    public Restaurant(String name) {
        this.name = name;
        this.dishes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}
