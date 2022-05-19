package com.citb408;

import java.io.Serializable;

public class TradeCenter implements Serializable {
    private String name;
    private transient String address;
    private static double tax;

    public TradeCenter(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public static double getTax() {
        return tax;
    }

    @Override
    public String toString() {
        return "TradeCenter{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
