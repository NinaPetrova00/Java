import dao.CompanyDAO;
import dao.EmployeeDAO;
import entity.Company;
import entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        Company company = CompanyDAO.getCompany(8);
        company.setFoundationDate(LocalDate.of(2008, 3, 12));
        company.setInitialCapital(BigDecimal.valueOf(7000));
        CompanyDAO.saveOrUpdateCompany(company);
        System.out.println(company);
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

        // select * from company where initial_capital > 6000
        System.out.println("---------------------------------- Companies with initial capital greater than 6000 ----------------------------------");
        List<Company> companies = CompanyDAO.companiesWithInitialCapitalGreaterThan(6000);
        companies.stream().forEach(System.out::println);

        // select * from company where initial_capital between 5000 and 8000
        System.out.println("---------------------------------- Companies with initial capital between 5000 and 8000 ----------------------------------");
        companies = CompanyDAO.companiesWithInitialCapitalBetween(5000, 8000);
        companies.stream().forEach(System.out::println);

        // max initial capital
        System.out.println("---------------------------------- Max Initial Capital ----------------------------------");
        BigDecimal maxInitialCapital = CompanyDAO.maxInitialCapital();
        System.out.println("Max initial capital is " + maxInitialCapital);

        // select * from company where name = DHL
        System.out.println("---------------------------------- Companies with name \"DHL\" ----------------------------------");
        companies = CompanyDAO.companiesWithNameEqualTo("DHL");
        companies.stream().forEach(System.out::println);

//        dao.CompanyDAO.deleteCompany(company);

//        entity.Company company = new entity.Company();
//        company.setId(1);
//        company.setName("DHL");
//        company.setAddress("Sofia");
//
//        dao.CompanyDAO.saveCompany(company);

//        List<entities.entity.Company> companyList = Arrays
//                .asList(new entities.entity.Company(1,"Nestle", "Plovdiv"), new entities.entity.Company(2,"SAP", "Sofia"));
//        dao.dao.CompanyDAO.saveCompanies(companyList);
//        companyList = dao.dao.CompanyDAO.readCompanies();
//        companyList.stream().forEach(System.out::println);
//
//        entities.entity.Owner owner = new entities.entity.Owner("Ivanov");
//        dao.dao.OwnerDAO.saveOwner(owner);
//        entities.entity.Owner owner1 = new entities.entity.Owner("Petrov");
//        dao.dao.OwnerDAO.saveOwner(owner1);
    }
}
