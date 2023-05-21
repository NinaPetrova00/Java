import dao.CompanyDAO;
import entity.Company;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        // READ
        Company company = CompanyDAO.getCompany(8);
        company.setFoundationDate(LocalDate.of(2008, 3, 12));
        company.setInitialCapital(BigDecimal.valueOf(7000));
        CompanyDAO.saveOrUpdateCompany(company);
        System.out.println(company);

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

        CompanyDAO.deleteCompany(company);

        Company company1 = new Company();
        company.setId(1);
        company.setName("DHL");
        company.setAddress("Sofia");

        CompanyDAO.saveCompany(company);

        List<entities.Company> companyList = Arrays
                .asList(new entities.Company(1, "Nestle", "Plovdiv"), new entities.Company(2, "SAP", "Sofia"));
        dao.CompanyDAO.saveCompanies(companyList);
        companyList = dao.CompanyDAO.readCompanies();
        companyList.stream().forEach(System.out::println);

        entities.Owner owner = new entities.Owner("Ivanov");
        dao.OwnerDAO.saveOwner(owner);
        entities.Owner owner1 = new entities.Owner("Petrov");
        dao.OwnerDAO.saveOwner(owner1);
    }
}
