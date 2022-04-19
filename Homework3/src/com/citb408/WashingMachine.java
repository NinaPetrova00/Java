package com.citb408;

public class WashingMachine extends ElectricDevice{

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
