package com.citb408.task2;

import java.math.BigDecimal;

public class Studio {
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
            this.pricePerHour =Studio.minPricePerHour;
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
