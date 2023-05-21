package com.cscb525;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Task 1 and Task 2 Week 2
 *
 * @author Kostadinova
 */
public enum Priority {
    HIGH(0), MEDIUM(1), LOW(2);

    private final int code;

    private Priority(int code) {
        this.code = code;
    }

    public static Priority getHIGH() {
        return HIGH;
    }

    public static Priority getMEDIUM() {
        return MEDIUM;
    }

    public static Priority getLOW() {
        return LOW;
    }

    public int getCode() {
        return code;
    }

}
