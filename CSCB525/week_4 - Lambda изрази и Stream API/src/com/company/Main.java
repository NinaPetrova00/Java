package com.company;


import com.company.lambda.*;
import com.company.streamAPI.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        // Lambda Expressions
        {

            // Task 1
            DistanceFunc distance = (point1, point2)
                    -> Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2)
                    + Math.pow(point1.getY() - point2.getY(), 2));
            Point p1 = new Point(1, 1);
            Point p2 = new Point(3, 4);

            System.out.println("Distance between point1 and point2 is: " + distance.func(p1, p2));
        }

        // Stream API
        {
            // Task 2.1
            System.out.println("---------------- Task 2.1 ----------------");
            IntStream.range(10, 101)
                    .filter(a -> a % 3 != 0)
                    .forEach(System.out::println);
            System.out.println();

            List<Integer> myListOfNumbers = new ArrayList<>();
            myListOfNumbers.add(9);
            myListOfNumbers.add(16);
            myListOfNumbers.add(25);

            Stream<Double> sqrtRootStrm = myListOfNumbers
                    .stream()
                    .map((a) -> Math.sqrt(a));
            // Find the product of the square roots.
            double productOfSqrRoots = sqrtRootStrm.reduce(1.0, (a, b) -> a * b);
            System.out.println("Product of square roots is " + productOfSqrRoots);

            // Task 2.2
            Employee ivan = new Employee("Ivan", 19, "Sofia");
            Employee pesho = new Employee("Pesho", 22, "Plovdiv");
            Employee gosho = new Employee("Gosho", 29, "Pazardjik");
            Employee ema = new Employee("Ema", 24, "Samokov");
            Employee bobi = new Employee("Bobi", 33, "Pernik");

            List<Employee> employeeList = new ArrayList();
            employeeList.add(ivan);
            employeeList.add(pesho);
            employeeList.add(gosho);
            employeeList.add(ema);
            employeeList.add(bobi);

            // Task 2.2
            System.out.println("---------------- Task 2.2 ----------------");
            Stream<Employee> employeeStream = employeeList.stream();
            employeeStream.sorted().forEach(System.out::println);

            // Task 2.3
            System.out.println("---------------- Task 2.3 ----------------");
            employeeStream = employeeList.stream();
            employeeStream
                    .filter(employee -> employee.getAddress().startsWith("P"))
                    .forEach(System.out::println);

            // Task 2.4
            System.out.println("---------------- Task 2.4 ----------------");
            Stream<String> fileLinesStream = null;
            try {
                fileLinesStream = Files.lines(Paths.get("src/CSCBF2020week8File.txt"))
                        .filter(a -> a.contains("o"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileLinesStream.forEach(a -> System.out.println(a));

            // Task 2.5
            System.out.println("---------------- Task 2.5 ----------------");
            List<String> fileLines = null;
            try {
                fileLines = Files.lines(Paths.get("src/CSCBF2020week8File.txt"))
                        .filter(a -> a.contains("o"))
                        .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileLines.forEach(a -> System.out.println(a));

            // Task 2.6
            System.out.println("---------------- Task 2.6 ----------------");
            employeeStream = employeeList.stream();
            employeeStream
                    .filter(employee -> employee.getAge() >= 18 && employee.getAge() <= 28)
                    .forEach(System.out::println);
        }
    }
}
