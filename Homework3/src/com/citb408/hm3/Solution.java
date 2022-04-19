package com.citb408.hm3;

class Manufacturer {
    String manufacturerName;
    boolean isLongTermWarranty;

    public Manufacturer(String manufacturerName, boolean isLongTermWarranty) {
        this.manufacturerName = manufacturerName;
        this.isLongTermWarranty = isLongTermWarranty;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public boolean isLongTermWarranty() {
        return isLongTermWarranty;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerName='" + manufacturerName + '\'' +
                ", isLongTermWarranty=" + isLongTermWarranty +
                '}';
    }
}
class ElectricDevice {
    Manufacturer manufacturer;
    int minWarranty;

    public ElectricDevice(Manufacturer manufacturer, int minWarranty) {
        this.manufacturer = manufacturer;
        this.minWarranty = minWarranty;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public int getMinWarranty() {
        return minWarranty;
    }

    public void setMinWarranty(int minWarranty) {
        if (minWarranty < 6) {
            this.minWarranty = 6;
        } else {
            this.minWarranty = minWarranty;
        }
    }
    public int warranty() {
        setMinWarranty(this.minWarranty);
        int newWaranty = this.minWarranty;
        if (manufacturer.isLongTermWarranty) {
            newWaranty += 12;
            return newWaranty;
        }
        return this.minWarranty;
    }

    @Override
    public String toString() {
        return "ElectricDevice{" +
                "manufacturer=" + manufacturer +
                ", minWarranty=" + minWarranty +
                '}';
    }
}
class Cooker extends ElectricDevice {

    boolean isGas;

    public Cooker(Manufacturer manufacturer, int minWarranty, boolean isGas) {
        super(manufacturer, minWarranty);
        this.isGas = isGas;
    }

    public boolean isGas() {
        return isGas;
    }

    @Override
    public int warranty() {
        int newWaranty =  super.warranty();
        if(this.isGas){
            newWaranty+=12;
        }
        //return super.warranty();
        return newWaranty;
    }

    @Override
    public String toString() {
        return "Cooker{" +
                "isGas=" + isGas +
                "} " + super.toString();
    }
}
class WashingMachine extends ElectricDevice{

    boolean isDryer;

    public WashingMachine(Manufacturer manufacturer, int minWarranty, boolean isDryer) {
        super(manufacturer, minWarranty);
        this.isDryer = isDryer;
    }

    public boolean isDryer() {
        return isDryer;
    }

    @Override
    public int warranty() {
        int newWarranty = super.warranty();
        if(this.isDryer){
            int addWaranty =this.minWarranty/2;
            newWarranty += addWaranty;
        }
        return newWarranty;
    }

    @Override
    public String toString() {
        return "WashingMachine{" +
                "isDryer=" + isDryer +
                "} " + super.toString();
    }
}
public class Solution {
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
