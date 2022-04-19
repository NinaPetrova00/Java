package com.citb408.figures;

public interface Increasable {
    default void increase(double number) { //default-но поведение на метода
        System.out.println("Increase data!");
    }

}
