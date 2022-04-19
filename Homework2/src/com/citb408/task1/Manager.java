package com.citb408.task1;

import java.time.LocalDate;
import java.time.Period;

public class Manager {
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
