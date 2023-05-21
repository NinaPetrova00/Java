/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.streamAPI;

/**
 * @author Kostadinova
 */
public class Employee implements Comparable<Employee> {

    private String name;
    private int age;
    private String address;

    public Employee() {
    }

    public Employee(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", age=" + age + ", address=" + address + '}';
    }

    @Override
    public int compareTo(Employee t) {
        return Integer.compare(this.age, t.age);
    }

}
