package com.cscb525;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Task 1
        {
            Employee maria = new Employee("Maria", 25);
            Employee pesho = new Employee("Pesho", 25);
            Employee elena = new Employee("Elena", 31);

            // ArrayList initial capacity
            System.out.println("---------------------ArrayList Initial Capacity--------------------");
            List<Employee> employees = new ArrayList(80);

            employees.add(maria);
            employees.add(pesho);
            employees.add(elena);

            employees.add(new Employee("Elena", 18));
            employees.add(new Employee("Ana", 18));

            System.out.println("Employees in ArrayList: " + employees);

            // LinkedList Example
            System.out.println("---------------------LinkedList Example--------------------");
            LinkedList<Employee> employeesInLinkedList = new LinkedList<>();

            employeesInLinkedList.add(maria);
            employeesInLinkedList.add(pesho);
            employeesInLinkedList.addFirst(elena);

            employeesInLinkedList.add(new Employee("Elena", 18));
            employeesInLinkedList.offerFirst(new Employee("Ana", 18));
            System.out.println("Employees in LinkedList: " + employeesInLinkedList);
            System.out.println("The last employee in the linked list" + employeesInLinkedList.getLast());
            employeesInLinkedList.pollFirst();
            employeesInLinkedList.removeFirst();

            // Example 1
            Company sap = new Company("SAP");
            sap.addEmployee(elena);
            sap.addEmployee(maria);
            System.out.println(sap.toString());

            System.out.println("sapEmpList: ");
            sap.displayEmployees();
            System.out.println("sapFirstHiredEmployee: " + sap.getFirstHiredEmployee());
            System.out.println("sapLastHiredEmployee: " + sap.getLastHiredEmployee());
            sap.removeEmployee(elena);
            sap.removeEmployee(maria);
            System.out.println("sapEmpList: ");
            sap.displayEmployees();
            sap.removeEmployee(maria);
            sap.addEmployees(employees);

            // Example 2.1 Iterator
            System.out.println("sapEmpList: ");
            sap.displayEmployees();

            // Example 2.2 ListIterator
            System.out.println("sapEmpList reversed: ");
            sap.displayEmployeesReversed();

            // Example 3.1 Print Sorted Employee List
            System.out.println("sapEmpList display sorted: ");
            sap.printSortedEmployeeList();

            // Example 3.2 Sort Employee List
            System.out.println("Sorted by name employee list: ");
            sap.sortEmployeeListByName();
            sap.displayEmployees();

            // Example 4. Collections.sort by two Comparators: EmployeeAge and EmployeeName
            System.out.println("Sorted by age (asc) employee list: ");
            sap.sortEmployeesByAge();
            sap.displayEmployees();

            System.out.println("Sorted by age (asc) and name (desc) employee list: ");
            sap.sortEmployeesByAgeAndByName();
            sap.displayEmployees();

        }
    }
}
