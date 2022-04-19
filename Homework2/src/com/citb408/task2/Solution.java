package com.citb408.task2;

import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) {

        /*
        long id = Long.parseLong(bufferedReader.readLine().trim());

        int maxWorkingHours = Integer.parseInt(bufferedReader.readLine().trim());

        double minPricePerHour = Double.parseDouble(bufferedReader.readLine().trim());

        double currencyEuro = Double.parseDouble(bufferedReader.readLine().trim());

        double pricePerHour = Double.parseDouble(bufferedReader.readLine().trim());

        int workedHours = Integer.parseInt(bufferedReader.readLine().trim());*/
        long id = 1;
        int maxWorkingHours = 15;
        double minPricePerHour =100;
        double currencyEuro = 0.51;
        double pricePerHour =0;
        int workedHours = 15;

        long id2 = 2;
        int maxWorkingHours2 = 18;
        double pricePerHour2 =150;
        int workedHours2 = 3;

        // Create an object of type Studio using the constructor with two parameters. Pass id and maxWorkingHours as arguments.
        Studio studio1 = new Studio(id, maxWorkingHours);
        // Use set method to set the minimum price per hour. User variable minPricePerHour to pass it as a method argument.
        studio1.setMinPricePerHour(minPricePerHour);
        // Use set method to set the Euro currency. Pass currencyEuro to the set method.
        studio1.setCurrencyEuro(currencyEuro);
        // Use set method to set the price for renting the studio for one hour. Pass pricePerHour to the set method.
        studio1.setPricePerHour(pricePerHour);
        // Use set method to set the number of hours for the day that the studio was rented.
        studio1.setWorkedHours(workedHours);
        // Print on the console the turnover in lv., calculated by using workedHours and pricePerHour.
        System.out.println(studio1.turnoverLv(studio1.getWorkedHours(), studio1.getPricePerHour()));
        // Print on the console the turnover in Euro., calculated by using workedHours and pricePerHour.
        System.out.println(studio1.turnoverEuro(studio1.getWorkedHours(), studio1.getPricePerHour()));

        // Create the second object of type Studio, using the constructor with 2 parameters. Use id2 and maxWorkingHours2 to pass them as arguments
        Studio studio2 = new Studio(id2, maxWorkingHours2);
        // Use set method to set the price for renting the second studio for one hour. Pass pricePerHour2 to the set method.
        studio2.setPricePerHour(pricePerHour2);
        // Use set method to set the number of hours for the day that the second studio was rented (workedHours2)
        studio2.setWorkedHours(workedHours2);

        // Print on the console the result of getting the id of the studio that is returned as a result of the studioWithLargerPrice() method. The first studio object is used to call the method.
        System.out.println(studio1.studioWithLargerPrice(studio1, studio2));
        // Print on the console the result of calling the method isFirstStudioWithGreaterTurnover() method. The first studio object is used to call the method.
        System.out.println(studio2.isFirstStudioWithGreaterTurnover(studio1, studio2));
    }
}
