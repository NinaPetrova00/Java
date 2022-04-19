package com.citb408;

public class Cooker extends ElectricDevice {

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
