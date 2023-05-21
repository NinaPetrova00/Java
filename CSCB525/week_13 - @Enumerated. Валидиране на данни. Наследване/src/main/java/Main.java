import dao.CompanyDAO;
import dao.CompanyEventDAO;
import dao.EmployeeDAO;
import entity.Company;
import entity.CompanyEvent;
import entity.CompanyEventType;
import entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        Company company;
       company = new Company("lindt", "Sofia", BigDecimal.valueOf(4000), LocalDate.of(2023, 10, 22));
     CompanyDAO.saveCompany(company);

        company = CompanyDAO.getCompany(8);
        company.setFoundationDate(LocalDate.of(2008, 3, 12));
        company.setInitialCapital(BigDecimal.valueOf(7000));
        CompanyDAO.saveOrUpdateCompany(company);
        System.out.println(company);

        CompanyEvent companyEvent = CompanyEventDAO.getCompanyEvent(1);
        companyEvent.setCompanyEventType(CompanyEventType.PARTY);
        CompanyEventDAO.saveOrUpdateCompanyEvent(companyEvent);
        companyEvent = CompanyEventDAO.getCompanyEvent(2);
        companyEvent.setCompanyEventType(CompanyEventType.EDUCATION);
        CompanyEventDAO.saveOrUpdateCompanyEvent(companyEvent);
        System.out.println(companyEvent);
        // get Company's Employees
        System.out.println("---------------------------------- Company's Employees----------------------------------");
//        company = CompanyDAO.getCompany(1);
//        company.getEmployees().stream().forEach(System.out::println);

        CompanyDAO.getCompanyEmployees(1).stream().forEach(System.out::println);
        CompanyDAO.getCompanyEmployeesDTO(1).stream().forEach(System.out::println);

        // get Employee's Company
        System.out.println("---------------------------------- Employee's Company ----------------------------------");
        Employee employee = EmployeeDAO.getEmployee(1);
        System.out.println(employee);
        // System.out.println(employee.getCompany());
        System.out.println(EmployeeDAO.getEmployeeCompany(1));

        // get Employee's CompanyEvents
        System.out.println("---------------------------------- Employee's CompanyEvents ----------------------------------");
        //employee.getCompanyEvents().stream().forEach(System.out::println);
        EmployeeDAO.getEmployeeCompanyEvents(1).stream().forEach(System.out::println);

        // Delete company with employees
        System.out.println("---------------------------------- Delete company with employees ----------------------------------");
        //Company company2 = CompanyDAO.getCompany(2);
        //CompanyDAO.deleteCompany(company2);


    }
}
