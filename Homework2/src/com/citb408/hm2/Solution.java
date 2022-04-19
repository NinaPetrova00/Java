package com.citb408.hm2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Solution {
    static class Manager {
        String name;
        LocalDate hiringDate;

        public Manager(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public LocalDate getHiringDate() {
            return hiringDate;
        }

        public void setHiringDate(LocalDate localDate) {
            LocalDate now = LocalDate.now();

            if (now.isBefore(localDate)) {
                this.hiringDate = LocalDate.of(2020, 1, 1);
            } else {
                this.hiringDate = localDate;
            }
        }

        public void numberOfYearsInCompanyTill(LocalDate currentDate) {
            Period period = Period.between(this.hiringDate, currentDate);
            System.out.println(period.getYears());
        }

        @Override
        public String toString() {
            return "Manager{" +
                    "name='" + name + '\'' +
                    ", hiringDate=" + hiringDate +
                    '}';
        }
    }
    static class Studio {
        final long id;
        BigDecimal pricePerHour;
        int maxWorkingHours;
        int workedHours;
        static BigDecimal minPricePerHour;
        BigDecimal currencyEuro;

        public Studio(long id, int maxWorkingHours) {
            this.id = id;
            this.maxWorkingHours = maxWorkingHours;
        }

        public void setMinPricePerHour(double minPricePerHour) {
            int res;
            res = BigDecimal.valueOf(minPricePerHour).compareTo(BigDecimal.valueOf(0));
            if (res == -1) {
                Studio.minPricePerHour = BigDecimal.valueOf(0);
            } else {
                Studio.minPricePerHour = BigDecimal.valueOf(minPricePerHour);
            }
        }

        public void setPricePerHour(double pricePerHour) {
            if (!(BigDecimal.valueOf(pricePerHour) == null)) {
                int res;
                res = BigDecimal.valueOf(pricePerHour).compareTo(this.getMinPricePerHour());
                if (res == -1) {
                    this.pricePerHour = this.getMinPricePerHour();
                } else {
                    this.pricePerHour = BigDecimal.valueOf(pricePerHour);
                }
            } else {
                this.pricePerHour = Studio.minPricePerHour;
            }
        }

        public void setWorkedHours(int workedHours) {
            if (workedHours > this.maxWorkingHours) {
                this.workedHours = this.maxWorkingHours;
            }else{
                this.workedHours = workedHours;
            }
        }

        public void setCurrencyEuro(double currencyEuro) {
            this.currencyEuro = BigDecimal.valueOf(currencyEuro);
        }

        public void setMaxWorkingHours(int maxWorkingHours) {
            if (maxWorkingHours < 0 || maxWorkingHours > 24) {
                this.maxWorkingHours = 24;
            } else {
                this.maxWorkingHours = maxWorkingHours;
            }
        }

        public long getId() {
            return id;
        }

        public BigDecimal getPricePerHour() {
            return pricePerHour;
        }

        public int getMaxWorkingHours() {
            return maxWorkingHours;
        }

        public int getWorkedHours() {
            return workedHours;
        }

        public BigDecimal getMinPricePerHour() {
            return minPricePerHour;
        }

        public BigDecimal getCurrencyEuro() {
            return currencyEuro;
        }

        public BigDecimal turnoverLv(int workedHours, BigDecimal pricePerHour) {

            return  pricePerHour.multiply(BigDecimal.valueOf(workedHours));
        }


        public BigDecimal turnoverEuro(int workedHours, BigDecimal pricePerHour) {
            BigDecimal price = this.currencyEuro.multiply(pricePerHour);

            return price.multiply(BigDecimal.valueOf(workedHours));
        }


        public long studioWithLargerPrice(Studio studio1, Studio studio2) {
            BigDecimal price1 = studio1.getPricePerHour();
            BigDecimal price2 = studio2.getPricePerHour();
            int res;
            res = price1.compareTo(price2);
            if (res == 1) {
                return studio1.getId();
            } else {
                return studio2.getId();
            }
        }

        public boolean isFirstStudioWithGreaterTurnover(Studio studio1, Studio studio2) {
            BigDecimal firstStudio = studio1.turnoverLv(studio1.workedHours, studio1.pricePerHour);
            BigDecimal secondStudio = studio2.turnoverLv(studio2.workedHours, studio2.pricePerHour);

            int res;
            res = firstStudio.compareTo(secondStudio);
            if (res == 1) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return "Studio{" +
                    "id=" + id +
                    ", pricePerHour=" + pricePerHour +
                    ", maxWorkingHours=" + maxWorkingHours +
                    ", workedHours=" + workedHours +
                    ", currencyEuro=" + currencyEuro +
                    '}';
        }
    }

    // Task 1
    public static void main(String[] args) {

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
