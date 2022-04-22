package com.citb408.deliveries;

import com.citb408.deliveries.Eatable;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String name;
    private List<Eatable> eatables;

    public Shop(String name) {
        this.name = name;
        this.eatables = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Eatable> getEatables() {
        return eatables;
    }
    public void addFoodStuff(FoodStuff foodStuff) {
        this.eatables.add(foodStuff);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", eatables=" + eatables +
                '}';
    }
}
