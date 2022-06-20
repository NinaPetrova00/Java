package com.citb408.Employees;

import java.math.BigDecimal;

public class Employee {
    private String name;
    private EmployeePosition position;
    private BigDecimal baseSalary;

    public Employee(String name, EmployeePosition position, BigDecimal baseSalary) {
        this.name = name;
        this.position = position;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
