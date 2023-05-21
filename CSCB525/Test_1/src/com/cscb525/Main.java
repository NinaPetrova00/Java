package com.cscb525;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Sweets sweets1 = new Sweets(123,"milka", LocalDate.of(2022,11,22),1.5,100, SweetsType.CHOCOLATE);
        Sweets sweets2 = new Sweets(173,"milka2", LocalDate.of(2022,10,22),5.5,100, SweetsType.BISQUITS);
        Sweets sweets3 = new Sweets(183,"milka3", LocalDate.of(2022,9,22),3.5,100, SweetsType.WAFFLE);

        Factory factory = new Factory("Nestle");

        factory.addSweetsInTheCollection(sweets1);
        factory.addSweetsInTheCollection(sweets2);
        factory.addSweetsInTheCollection(sweets3);

        factory.showSweetsOrder();

        factory.showSweetsOrderedByQuantity();

        factory.setPriceIncreasment(SweetsType.CHOCOLATE,5);
        factory.setPriceIncreasment(SweetsType.WAFFLE,2);
        factory.setPriceIncreasment(SweetsType.BISQUITS,1);

        factory.showSweetsCollectionWithPriceIncreasment();

        factory.showByPercentageOver10();
    }
}
