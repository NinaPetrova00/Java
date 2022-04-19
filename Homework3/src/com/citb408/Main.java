package com.citb408;

public class Main {

    public static void main(String[] args) {

        String manufacturerName = "ElDevMan";
        boolean isLongTermWarranty = true;
        int minWarranty = 12;
        boolean isGas = true;
        boolean isDryer = true;

        // 1.Create object of type Manufacturer using the constructor with two parameters.
        // Pass manufacturerName and isLongTermWarranty as arguments
        Manufacturer manufacturer = new Manufacturer(manufacturerName, isLongTermWarranty);

        // 2.Create object of type ElectricDevice using the constructor with 2 parameters.
        // Pass manufacturer and minWarranty as arguments: ElectricDevice electricDevice = new ElectricDevice(manufacturer, minWarranty);
        ElectricDevice electricDevice = new ElectricDevice(manufacturer, minWarranty);

        // 3.Print on the console the warranty of the the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());

        // 4.Assign the electricDevice a new object of type Cooker using the constructor with 3 parameters.
        // Pass manufacturer, price and minWarranty as arguments: electricDevice = new Cooker(manufacturer, minWarranty, isGas);
        electricDevice = new Cooker(manufacturer, minWarranty, isGas);

        // 5.Print on the console the warranty of the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());

        // 6.Assign the electricDevice a new object of type WashingMachine using the constructor with 3 parameters.
        // Pass manufacturer, price and minWarranty as arguments: electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);
        electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);

        // 7.Print on the console the warranty of the the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());
    }
}
