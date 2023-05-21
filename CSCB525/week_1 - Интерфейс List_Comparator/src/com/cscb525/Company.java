package com.cscb525;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 * @author Kostadinova
 */
public class Company {

    private String name;
    private List<Employee> employeeList;

    public Company() {
        this.name = "No Name";
        employeeList = new ArrayList();
    }

    public Company(String name) {
        this.name = name;
        employeeList = new ArrayList();
    }

    public Company(String name, List<Employee> employeeList) {
        this.name = name;
        this.employeeList = employeeList;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /*
     * Example 1.2
     * add employee in the list of employees
     */
    public void addEmployee(Employee employee) {

        employeeList.add(employee);
    }

    public void addEmployees(List<Employee> employees) {

        employeeList.addAll(employees);
    }

    /*
     * Example 1.3
     * remove employee from the list of employees
     */
    public void removeEmployee(Employee employee) {
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
        } else {
            System.out.println("This employee " + employee + " is not in the list!");
        }
    }

    /*
     * Example 1.4
     * return the last hired employee in the list of employees
     */
    public Employee getLastHiredEmployee() {
        return employeeList.get(employeeList.size() - 1);
    }

    /*
     * Example 1.5
     * return the first hired employee in the list of employees
     */
    public Employee getFirstHiredEmployee() {
        return employeeList.get(0);
    }

    /*
     * Example 2.1
     * display employees
     */
    public void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("There are no employees!");
        } else {
            Iterator<Employee> iterator = employeeList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next() + " ");
            }
        }
    }

    /*
     * Example 2.2
     * display employees in reversed order
     */
    public void displayEmployeesReversed() {
        if (employeeList.isEmpty()) {
            System.out.println("There are no employees!");
        } else {
            ListIterator<Employee> listIterator =
                    employeeList.listIterator(employeeList.size());
            while (listIterator.hasPrevious()) {
                System.out.println(listIterator.previous() + " ");
            }
        }
    }

    /*
     * Example 3.1
     * display the elements in the list of employees, the elements are displayed sorted by name ascending
     */
    public void printSortedEmployeeList() {
        List<Employee> copyEmployeeList = new ArrayList<>(employeeList);
        // using sort() method from List interface
        copyEmployeeList.sort(Employee.EmployeeName);
        System.out.println(copyEmployeeList);
    }

    /*
     * Example 3.2
     * sort elements in the list of employees using Collections utility class
     */
    public void sortEmployeeListByName() {
        // using sort() method from Collections class
        Collections.sort(employeeList);
    }

    /*
     * Example 4.3
     * sort by age all elements in the list of employees
     */
    public void sortEmployeesByAge() {
        Collections.sort(employeeList, Employee.EmployeeAge);
    }


    /*
     * Example 4.4
     * sort by age and than by name all elements in the list of employees
     */
    public void sortEmployeesByAgeAndByName() {
        Collections
                .sort(employeeList,
                Employee.EmployeeAge
                        .thenComparing(Employee.EmployeeName.reversed()));
    }

    @Override
    public String toString() {
        return "com.cscb525.Company{" + "name=" + name + ", employeeList=" + employeeList + '}';
    }

}
