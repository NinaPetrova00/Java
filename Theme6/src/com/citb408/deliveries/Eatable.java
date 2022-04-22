package com.citb408.deliveries;

public interface Eatable {

   default void eat() {
        System.out.println("Delicious!");
    }
}
