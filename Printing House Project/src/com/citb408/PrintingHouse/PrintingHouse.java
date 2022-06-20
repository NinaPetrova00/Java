package com.citb408.PrintingHouse;

import com.citb408.Employees.Employee;
import com.citb408.Employees.EmployeePosition;
import com.citb408.Publication.Publication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrintingHouse {
    private BigDecimal minProfit; //ако приходите на печатницата са повече от определена стойност, която се задава в печатницата.
    private List<Employee> employeeList;
    private List<Publication> publicationList;
    private int minPublicationCount;
    private BigDecimal makeDiscount; //Ако отпечатваните издания надхвърлят предварително зададен брой, на клиентите се прави отстъпка с определен%
    private BigDecimal increaseManagerSalary;

    public PrintingHouse(BigDecimal minProfit, int minPublicationCount, BigDecimal makeDiscount, BigDecimal increaseManagerSalary) {
        this.minProfit = minProfit;
        this.minPublicationCount = minPublicationCount;
        employeeList = new ArrayList<>();
        publicationList = new ArrayList<>();
        this.makeDiscount = makeDiscount;
        this.increaseManagerSalary = increaseManagerSalary;
    }

    public BigDecimal getMinProfit() {
        return minProfit;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public BigDecimal getMakeDiscount() {
        return makeDiscount;
    }

    public BigDecimal getIncreaseManagerSalary() {
        return increaseManagerSalary;
    }

    public int getMinPublicationCount() {
        return minPublicationCount;
    }

    // method for calculating incomes
    public BigDecimal calculateIncomes() {
        BigDecimal price = BigDecimal.valueOf(0);
        for (Publication publication : publicationList) {
            price = price.add(publication.pricePerPublication());
        }

        BigDecimal printedPublicationsCount = BigDecimal.valueOf(this.publicationList.size());

        if (printedPublicationsCount.compareTo(BigDecimal.valueOf(minPublicationCount)) == 1
                || printedPublicationsCount.compareTo(BigDecimal.valueOf(minPublicationCount)) == 0) {
            //make discount
            BigDecimal discount = makeDiscount.divide(BigDecimal.valueOf(100)); // 2%
            price = price.subtract(price.multiply(discount));
        }
        return price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    // method for calculating expenses
    public BigDecimal calculateExpenses() {
        BigDecimal employeeExpenses = BigDecimal.valueOf(0);
        for (Employee employee : employeeList) {
            employeeExpenses = employeeExpenses.add(employee.getBaseSalary());
        }

        BigDecimal paperExpenses = BigDecimal.valueOf(0);
        for (Publication publication : publicationList) {
            paperExpenses = paperExpenses.add(publication.expensesForPaper());
        }
        return paperExpenses.add(employeeExpenses).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    // method for checking Employee's salary
    public void checkSalary(Employee employee) {
        System.out.println("Name: " + employee.getName()
                + " Position: " + employee.getPosition() +
                " Salary: " + employee.getBaseSalary().setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }

    //method for changing Employee Salary if he is a Manager
    public void increaseManagerSalary(Employee employee) {
        BigDecimal increasementPercentage = increaseManagerSalary.divide(BigDecimal.valueOf(100)); //10%
        BigDecimal incomes = calculateIncomes();

        if (employee.getPosition().equals(EmployeePosition.MANAGER)) {
            if ((incomes.compareTo(this.minProfit)) == 1 || (incomes.compareTo(this.minProfit)) == 0) {
                BigDecimal baseSalary = employee.getBaseSalary();
                //change Manager's salary
                employee.setBaseSalary(baseSalary.add(baseSalary.multiply(increasementPercentage)));
            }
        }
    }

    // method to add employees in the printing house
    public void addEmployee(Employee employee) {
        if (!this.employeeList.contains(employee)) {
            // check position of Employee
            increaseManagerSalary(employee);
            this.employeeList.add(employee);
        }
    }

    // method to add publications in the printing house
    public void addPublication(Publication publication) {
        if (!this.publicationList.contains(publication)) {
            this.publicationList.add(publication);
        }
    }

    @Override
    public String toString() {
        return "PrintingHouse{" +
                "minProfit=" + minProfit +
                ", employeeList=" + employeeList +
                ", publicationList=" + publicationList +
                ", minPublicationCount=" + minPublicationCount +
                ", makeDiscount=" + makeDiscount +
                ", increaseManagerSalary=" + increaseManagerSalary +
                '}';
    }
}
