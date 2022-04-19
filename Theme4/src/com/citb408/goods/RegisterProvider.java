package com.citb408.goods;

public abstract class RegisterProvider implements Provider {
    private String type;
    private String regNumber;

    public RegisterProvider(String type, String regNumber) {
        this.type = type;
        this.regNumber = regNumber;
    }

    @Override
    public String toString() {
        return "RegisterProvider{" +
                "type='" + type + '\'' +
                ", regNumber='" + regNumber + '\'' +
                '}';
    }
}
