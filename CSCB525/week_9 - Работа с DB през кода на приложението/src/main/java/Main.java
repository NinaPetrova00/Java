import dao.CompanyDAO;
import dao.OwnerDAO;
import entity.Company;
import entity.Owner;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        Company company = new Company();
        company.setId(1);
        company.setName("DHL");
        company.setAddress("Sofia");

        /* тук сесията се отваря, тя е autocloseable и се затваря сама*/
        /* в момента, в който се отвори сесисията, в този момент се update-ва базата*/
        /* първо се изпълняват update-тите, после се изпълняват insert-ите*/
        CompanyDAO.saveCompany(company);

        List<Company> companyList = Arrays
                .asList(new Company(1, "Nestle", "Plovdiv"),
                        new Company(2, "SAP", "Sofia"));
        CompanyDAO.saveCompanies(companyList);
        companyList = CompanyDAO.readCompanies();
        companyList.stream().forEach(System.out::println);

        Owner owner = new Owner("Ivanov");
        OwnerDAO.saveOwner(owner);
        Owner owner1 = new Owner("Petrov");
        OwnerDAO.saveOwner(owner1);
    }
}
