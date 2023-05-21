package com.cscb525;

import java.util.*;

public class Factory {
    private String name;
    private List<Sweets> sweetsList;
    /*Във фабриката трябва да се пази колекция от данни, в която се съхранява информация
        за процентът надценка на всеки тип захарно изделие*/
    private Map<SweetsType,Integer> priceIncreasmentByTypeList;
    /*колекция от данни, в която е асортиментът на фабриката.
    Захраните изделия в колекцията не трябва да се повтарят*/
    private Set<Sweets> factoryAssortment;

    public Factory(String name) {
        this.name = name;
        this.sweetsList = new ArrayList<>();
        this.priceIncreasmentByTypeList = new EnumMap<>(SweetsType.class);
        this.factoryAssortment = new TreeSet<>();
    }

    /*Task 1 - 1. Добавяне на захарно изделие в колекцията.*/
    public void addSweetsInTheCollection(Sweets sweets){
        sweetsList.add(sweets);
    }

    /*Task 1 - 2.Показване на реда, в който са произведени захарните изделия.*/
    public void showSweetsOrder(){
        sweetsList.stream().forEach(System.out::println);
    }

    /*Task 1 - 3.Показване на захарните изделия, подредени по произведеното количество*/
   public void showSweetsOrderedByQuantity(){
        sweetsList.stream()
                .sorted(Comparator.comparing(Sweets::getProducedQuantity))
                .forEach(System.out::println);
    }

    /*Task 2 - 1.Показване на колекцията с типовете захарни изделия и процентът надценка, който ще
                се използва за изчисляване на продажната цена.*/
    public void setPriceIncreasment(SweetsType sweetsType, int priceIncr){
        priceIncreasmentByTypeList.put(sweetsType,priceIncr);
    }

    public void showSweetsCollectionWithPriceIncreasment(){
        priceIncreasmentByTypeList.entrySet().stream().forEach(System.out::println);
    }

    /*Task 2 - 2.Показване на елементите на колекцията с типовете захарни изделия, подредени по
                следния начин: първо CHOCOLATE, след това BISQUITS и накрая WAFFLE.*/
/*    public void showSweetsTypeOrdered(){
        priceIncreasmentByTypeList
        }*/

    /*Task 2 - 3.Показване на елементите на колекцията с типовете захарни изделия,
                 чиито процент надвишава 10.*/
    public void showByPercentageOver10(){
         priceIncreasmentByTypeList.entrySet().stream().filter(a->a.getValue()>=10).forEach(System.out::println);
    }

    /*Task 3 - 1.Показване на захарните изделия, подредени по единичната цена в намаляващ ред */
     /*   public void showsweetsInFactoryOrderedByPrice(){

        }*/

    /*Task 3 - 2.Показване на захарните изделия, подредени по датата на производство
                и след това по името в нарастващ ред.*/

    /*Task 3 - 3.Показване на захарните изделия, които са от категория CHOCOLATE.*/

    /*Task 3 - 4.Връщане на колекция от захарни изделия, които са с произведено количество, поголямо от 200.*/

    @Override
    public String toString() {
        return "Factory{" +
                "name='" + name + '\'' +
                ", sweetsList=" + sweetsList +
                ", priceIncreasmentByTypeList=" + priceIncreasmentByTypeList +
                ", factoryAssortment=" + factoryAssortment +
                '}';
    }
}
