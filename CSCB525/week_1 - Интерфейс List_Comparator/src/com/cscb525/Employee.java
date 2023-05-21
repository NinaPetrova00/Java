package com.cscb525;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Comparator;

/**
 * @author Kostadinova
 */
public class Employee implements Comparable<Employee> {

    private String name;
    private int age;

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", age=" + age + '}';
    }

    @Override
    public int compareTo(Employee employee) {

        return this.name.compareTo(employee.name);
    }

    /*
     * Task 4.1
     * comparator that compares employees by name
     */
    public static Comparator<Employee> EmployeeName =
            new Comparator<Employee>() {
        @Override
        public int compare(Employee employee, Employee employee1) {

            return employee.name.compareTo(employee1.name);
        }
    };

    /*
     * Task 4.2
     * comparator that compares employees by age
     */

    public static Comparator<Employee> EmployeeAge =
            new Comparator<Employee>() {
        @Override
        public int compare(Employee employee, Employee employee1) {
            return Integer.compare(employee.age, employee1.age);
        }
    };


}
