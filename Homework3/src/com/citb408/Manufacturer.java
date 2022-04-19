package com.citb408;

public class Manufacturer {
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
