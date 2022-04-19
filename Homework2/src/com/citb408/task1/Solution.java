package com.citb408.task1;

import java.time.LocalDate;

public class Solution {

    public static void main(String[] args) {
/*Ivan
2021
4
1
2021
5
3*/
        String name = "Ivan";
        int hiringYear = 2021;

        int hiringMonth = 4;

        int hiringDay = 1;

        int currentYear = 2021;

        int currentMonth = 5;

        int currentDay = 3;

        // Create an object of type Manager. Use one parameter constructor with argument name: Manager(name)
        Manager manager = new Manager(name);

        // Call the set method to set the hiring date of Ivan. Pass year, month, and day as parameters:
        // setHiringDate(LocalDate.of(hiringYear, hiringMonth, hiringDay))
        manager.setHiringDate(LocalDate.of(hiringYear, hiringMonth, hiringDay));

        // Print on the console the result of getting the hiring date
        System.out.println(manager.getHiringDate());
        // Print on the console the result of calling numberOfYearsInCompanyTill() method. The method has to be called with a parameter of type LocalDate using currentYear, currentMonth, currentDay: numberOfYearsInCompanyTill(LocalDate.of(currentYear, currentMonth, currentDay))
        manager.numberOfYearsInCompanyTill(LocalDate.of(currentYear, currentMonth, currentDay));
    }
}
