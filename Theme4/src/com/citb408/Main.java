package com.citb408;

import com.citb408.goods.ItemForSale;
import com.citb408.goods.Vehicle;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(10, 1000, 2000);
        System.out.println(vehicle.productionPrice());
        System.out.println(vehicle.sellingPrice());

        ItemForSale itemForSale;
        itemForSale = vehicle;
        System.out.println(itemForSale.productionPrice());
        System.out.println(itemForSale.sellingPrice());
    }
}
