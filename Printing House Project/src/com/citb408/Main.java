package com.citb408;

import com.citb408.Employees.Employee;
import com.citb408.Employees.EmployeePosition;
import com.citb408.Paper.Paper;
import com.citb408.Paper.PaperSize;
import com.citb408.Paper.PaperType;
import com.citb408.PrintingHouse.PrintingHouse;
import com.citb408.PrintingMachine.InsufficientPaperException;
import com.citb408.PrintingMachine.PrintingMachine;
import com.citb408.PrintingMachine.PrintingType;
import com.citb408.Publication.Publication;
import com.citb408.Publication.PublicationType;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Write in file
    public static void writePrintingMachineData(String outputFileName, PrintingMachine printingMachine) {
        try (FileWriter fout = new FileWriter(new File(outputFileName), true)) {
            if (printingMachine != null) {
                fout.append(printingMachine.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writePrintingHouseData(String outputFileName, PrintingHouse printingHouse) {
        try (FileWriter fout = new FileWriter(new File(outputFileName), true)) {
            if (printingHouse != null) {
                fout.append(printingHouse.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeIncomes(String outputFileName, BigDecimal incomes) {
        try (FileWriter fout = new FileWriter(new File(outputFileName), true)) {
            if (incomes != null) {
                fout.append("Incomes: ");
                fout.append(incomes.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeExpenses(String outputFileName, BigDecimal expenses) {
        try (FileWriter fout = new FileWriter(new File(outputFileName), true)) {
            if (expenses != null) {
                fout.append("Expenses: ");
                fout.append(expenses.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read from file
    public static List<String> readPrintingMachineFromFile(String inputFileName) {
        List<String> listOfPrintingMachines = new ArrayList<>();
        try (FileReader fis = new FileReader(inputFileName)) {
            BufferedReader bufferedReader = new BufferedReader(fis);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listOfPrintingMachines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfPrintingMachines;
    }

    public static void main(String[] args) {

        // Paper
        Paper normalPaper = new Paper(PaperSize.A5, PaperType.NORMAL);
        Paper newsPrintPaper = new Paper(PaperSize.A3, PaperType.NEWSPRINT);
        Paper glossyPaper = new Paper(PaperSize.A4, PaperType.GLOSSY);

        //Publication
        BigDecimal overCharge = BigDecimal.valueOf(5); // надценка, с която ще продаваме изданието

        Publication book = new Publication(PublicationType.BOOK, "Harry Potter", 250, normalPaper, overCharge);
        Publication newspaper = new Publication(PublicationType.NEWSPAPER, "Daily news", 20, newsPrintPaper, overCharge);
        Publication magazine = new Publication(PublicationType.MAGAZINE, "Vogue", 30, glossyPaper, overCharge);
        Publication poster = new Publication(PublicationType.POSTER, "Happy dog", 1, glossyPaper, overCharge);

        ArrayList<Publication> publicationList = new ArrayList<>();
        publicationList.add(book);
        publicationList.add(newspaper);
        publicationList.add(magazine);
        publicationList.add(poster);

        // Employee
        BigDecimal baseEmployeeSalary = BigDecimal.valueOf(500);
        Employee employee1 = new Employee("Ivan", EmployeePosition.MANAGER, baseEmployeeSalary);
        Employee employee2 = new Employee("Petar", EmployeePosition.OPERATOR, baseEmployeeSalary);
        Employee employee3 = new Employee("Mira", EmployeePosition.OPERATOR, baseEmployeeSalary);
        Employee employee4 = new Employee("Ani", EmployeePosition.MANAGER, baseEmployeeSalary);

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);

        // Printing machine
        PrintingMachine printingMachine1 = new PrintingMachine(200, PrintingType.COLOR, "Machine 1");
        PrintingMachine printingMachine2 = new PrintingMachine(800, PrintingType.BLACKANDWHITE, "Machine 2");
        // Add publications into machines
        printingMachine1.addPublicationInMachine(magazine);
        printingMachine1.addPublicationInMachine(poster);
        printingMachine2.addPublicationInMachine(book);
        printingMachine2.addPublicationInMachine(newspaper);
        // Exception
        try {
            printingMachine1.printing();
            printingMachine2.printing();
        } catch (InsufficientPaperException e) {
            e.printStackTrace();
        }
        // Threads
        Thread thread1 = new Thread(printingMachine1, "Print 1");
        Thread thread2 = new Thread(printingMachine2, "Print 2");
        thread1.start();
        thread2.start();

        // Printing House
        BigDecimal clientDiscount = BigDecimal.valueOf(2);
        BigDecimal increaseSalary = BigDecimal.valueOf(10);
        PrintingHouse printingHouse = new PrintingHouse(BigDecimal.valueOf(50), 10, clientDiscount, increaseSalary);
        // Add publications and employees
        printingHouse.addPublication(book);
        printingHouse.addPublication(newspaper);
        printingHouse.addPublication(poster);
        printingHouse.addPublication(magazine);
        printingHouse.addEmployee(employee1);
        printingHouse.addEmployee(employee2);
        printingHouse.addEmployee(employee3);
        printingHouse.addEmployee(employee4);

        // Check incomes and expenses
        System.out.println("Incomes: " + printingHouse.calculateIncomes());
        System.out.println("Expenses: " + printingHouse.calculateExpenses());
        // Check employee's salary
        printingHouse.checkSalary(employee1);
        printingHouse.checkSalary(employee2);
        printingHouse.checkSalary(employee3);
        printingHouse.checkSalary(employee4);

        // write in file
        String fileName = "files/PrintingHouseData.txt";

        writePrintingMachineData(fileName, printingMachine1);
        writePrintingMachineData(fileName, printingMachine2);

        writePrintingHouseData(fileName, printingHouse);
        writeIncomes(fileName, printingHouse.calculateIncomes());
        writeExpenses(fileName, printingHouse.calculateExpenses());

        // read from file
        List<String> machineList = new ArrayList<>(readPrintingMachineFromFile(fileName));
        System.out.println("--------------Reading file----------------------");
        for (String m : machineList) {
            System.out.println(m);
        }
    }
}
