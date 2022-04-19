package com.citb408;

public class ElectricDevice {
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
