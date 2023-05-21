import dao.*;
import entity.*;

import org.hibernate.Session;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // write in file
    public static void writePaymentData(String outputFileName, Payment payment) {
        try (FileWriter fout = new FileWriter(new File(outputFileName), true)) {
            if (payment != null) {
                fout.append("------------New payment------------" + System.lineSeparator());
                fout.append("Paid date: ");
                fout.append(payment.getPaymentDate() + System.lineSeparator());

                fout.append("Paid sum: ");
                fout.append(payment.getPaidSum() + System.lineSeparator());

                fout.append("Apartment: ");
                fout.append("apartment number: " + payment.getApartment().getNumber() + ", floor: " + payment.getApartment().getFloor() + System.lineSeparator());

                fout.append("Building: ");
                fout.append("id: " + payment.getApartment().getBuilding().getId() + ", address: " + payment.getApartment().getBuilding().getAddress() + System.lineSeparator());

                //          fout.append("Employee: ");
                //  fout.append(payment.getApartment().getBuilding().getContract().getEmployee().getName() + System.lineSeparator());

                //                fout.append("Company --> ");
//                fout.append(payment.getApartment().getBuilding().getContract().getEmployee().getName() + System.lineSeparator());
                //    fout.append(payment.toString() + System.lineSeparator());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Companies
        Company company1 = new Company(1, "ProHome", "Sofia");
        Company company2 = new Company(2, "HomeExpert", "Varna");
        Company company3 = new Company(3, "Test", "Test");
        Company company4 = new Company(4, "HappyBuilding", "Burgas");
        //create
//        CompanyDAO.createCompany(company1);
//        CompanyDAO.createCompany(company2);
//         CompanyDAO.createCompany(company3);
//         CompanyDAO.createCompany(company4);
        //update
        company3 = CompanyDAO.getCompanyById(3);
        company3.setName("HomePeace");
        company3.setAddress("Plovdiv");
        CompanyDAO.saveOrUpdateCompany(company3);
        //delete
////        Company company_4 = CompanyDAO.getCompanyById(4);
////        CompanyDAO.deleteCompany(company_4);
//
//
//        // Buildings
        Building building1 = new Building(1, "Sofia", 3, BigDecimal.valueOf(160), BigDecimal.valueOf(50), 9);
        Building building2 = new Building(2, "Varna", 5, BigDecimal.valueOf(190), BigDecimal.valueOf(60), 15);
        Building building3 = new Building(3, "Varna", 5, BigDecimal.valueOf(180), BigDecimal.valueOf(70), 15);
        Building building4 = new Building(4, "Burgas", 6, BigDecimal.valueOf(200), BigDecimal.valueOf(90), 18);
        //create
//        BuildingDAO.createBuilding(building1);
//        BuildingDAO.createBuilding(building2);
//        BuildingDAO.createBuilding(building3);
        //       BuildingDAO.createBuilding(building4);
//        //update
//        building3 = BuildingDAO.getBuildingById(3);
//        building5.setFloors(2);
//        building5.setNumberOfApartments(10);
//        BuildingDAO.saveOrUpdateBuilding(building5);
//        //delete
////       Building building_4 = BuildingDAO.getBuildingById(4);
////       BuildingDAO.deleteBuilding(building_4);

//        // Owner
        Owner owner1 = new Owner(1, "Ivan", LocalDate.of(1978, 1, 1), false);
        Owner owner2 = new Owner(2, "Peter", LocalDate.of(1988, 2, 15), true);
        Owner owner3 = new Owner(3, "Maria", LocalDate.of(1998, 12, 25), true);
        // create owner
//        OwnerDAO.createOwner(owner1);
//        OwnerDAO.createOwner(owner2);
//        OwnerDAO.createOwner(owner3);
        // update owner
        owner3 = OwnerDAO.getOwnerById(3);
        owner3.setBirthDate(LocalDate.of(1995, 12, 25));
        OwnerDAO.saveOrUpdateOwner(owner3);
        //delete owner
//        Owner owner_4 = OwnerDAO.getOwnerById(4);
//        OwnerDAO.deleteOwner(owner_4);
//        Owner owner_5 = OwnerDAO.getOwnerById(5);
//        OwnerDAO.deleteOwner(owner_5);

        // Apartments
        Apartment apartment1 = new Apartment(1, 1, 1, BigDecimal.valueOf(50), owner1, building1);
        Apartment apartment2 = new Apartment(2, 1, 2, BigDecimal.valueOf(60), owner1, building1);
        Apartment apartment3 = new Apartment(3, 2, 3, BigDecimal.valueOf(70), owner1, building1);
        Apartment apartment4 = new Apartment(4, 2, 4, BigDecimal.valueOf(80), owner1, building1);
        //create
//        ApartmentDAO.createApartment(apartment1);
//       ApartmentDAO.createApartment(apartment2);
//        ApartmentDAO.createApartment(apartment3);
//        ApartmentDAO.createApartment(apartment4);
        // update
        apartment3 = ApartmentDAO.getApartmentById(3);
        apartment3.setOwner(owner2);
        ApartmentDAO.saveOrUpdateApartment(apartment3);
        // delete
//        apartment3 = ApartmentDAO.getApartmentById(3);
//        ApartmentDAO.deleteApartment(apartment3);

        //   Inhabitant
        Inhabitant inhabitant1 = new Inhabitant(1, "Georgi", LocalDate.of(2000, 5, 5), true, apartment1);
        Inhabitant inhabitant2 = new Inhabitant(2, "Ivan", LocalDate.of(2002, 7, 15), true, apartment1);
        Inhabitant inhabitant3 = new Inhabitant(3, "Angel", LocalDate.of(1990, 2, 7), true, apartment2);
        Inhabitant inhabitant4 = new Inhabitant(4, "Anna", LocalDate.of(1991, 2, 6), true, apartment2);
        Inhabitant inhabitant5 = new Inhabitant(5, "Anna", LocalDate.of(2021, 1, 18), false, apartment2);
        //create
        // InhabitantDAO.createInhabitant(inhabitant1);
//        InhabitantDAO.createInhabitant(inhabitant2);
//        InhabitantDAO.createInhabitant(inhabitant3);
//        InhabitantDAO.createInhabitant(inhabitant4);
//        InhabitantDAO.createInhabitant(inhabitant5);
        // update inhabitant
        inhabitant5 = InhabitantDAO.getInhabitantById(5);
        inhabitant5.setName("Lora");
        InhabitantDAO.saveOrUpdateInhabitant(inhabitant5);
        //  delete inhabitant
//        inhabitant1 = InhabitantDAO.getInhabitantById(1);
//         InhabitantDAO.deleteInhabitant(inhabitant1);

        // Employee
        // public Employee(long id, String name, Company company) {
        Employee employee1 = new Employee(1, "Dragan", company1);
        Employee employee2 = new Employee(2, "Kaloyan", company1);
        Employee employee3 = new Employee(3, "Nevena", company1);
        Employee employee4 = new Employee(4, "Asya", company1);
        Employee employee5 = new Employee(5, "Ivan", company2);
        Employee employee6 = new Employee(6, "Teodor", company2);
        Employee employee7 = new Employee(7, "Ralitsa", company2);
        Employee employee8 = new Employee(8, "Milena", company2);
        // create
//        EmployeeDAO.createEmployee(employee1);
        //      EmployeeDAO.createEmployee(employee2);
//        EmployeeDAO.createEmployee(employee3);
//        EmployeeDAO.createEmployee(employee4);
//        EmployeeDAO.createEmployee(employee5);
//        EmployeeDAO.createEmployee(employee6);
//        EmployeeDAO.createEmployee(employee7);
//        EmployeeDAO.createEmployee(employee8);

        // Pet
        Pet pet1 = new Pet(1, true, apartment1);
        Pet pet2 = new Pet(2, false, apartment1);
        Pet pet3 = new Pet(3, true, apartment2);
//        PetDAO.createPet(pet1);
//        PetDAO.createPet(pet2);
//        PetDAO.createPet(pet3);

        // Fee
        Fee fee1 = new Fee(1, BigDecimal.valueOf(2), BigDecimal.valueOf(0.50), BigDecimal.valueOf(1.50), BigDecimal.valueOf(1.80), apartment1);
        Fee fee2 = new Fee(2, BigDecimal.valueOf(2), BigDecimal.valueOf(0.50), BigDecimal.valueOf(1.50), BigDecimal.valueOf(1.80), apartment2);
        Fee fee3 = new Fee(3, BigDecimal.valueOf(2), BigDecimal.valueOf(0.50), BigDecimal.valueOf(1.50), BigDecimal.valueOf(1.80), apartment3);
        Fee fee4 = new Fee(4, BigDecimal.valueOf(2), BigDecimal.valueOf(0.50), BigDecimal.valueOf(1.50), BigDecimal.valueOf(1.80), apartment4);
//        FeeDAO.createFee(fee1);
//        FeeDAO.createFee(fee2);
//        FeeDAO.createFee(fee3);
//        FeeDAO.createFee(fee4);

        //Payment
        Payment payment1 = new Payment(1, LocalDate.of(2021, 1, 5), apartment1);
        Payment payment2 = new Payment(2, LocalDate.of(2021, 2, 5), apartment1);
        Payment payment3 = new Payment(3, LocalDate.of(2021, 3, 5), apartment1);
        Payment payment4 = new Payment(4, LocalDate.of(2022, 1, 1), apartment2);

//        PaymentDAO.createPayment(payment1);
//        PaymentDAO.createPayment(payment2);

        //Contract
        Contract contract1 = new Contract(1, building1, employee1);
        Contract contract2 = new Contract(2, building2, employee1);
        Contract contract3 = new Contract(3, building3, employee2);
//Contract contract4 = new Contract(4, building4, CompanyDAO.findEmployeeWithLeastBuildings(company2.getId()));

//        ContractDAO.createContract(contract1);
//        ContractDAO.createContract(contract2);
//        ContractDAO.createContract(contract3);
//      ContractDAO.createContract(contract4);

        //works
        System.out.println("-----------Sort employees by name-----------");
        EmployeeDAO.sortEmployeesByName(company1.getId());
        EmployeeDAO.sortEmployeesByName(company4.getId());

        //works
        System.out.println("-----------Filter employees by name-----------");
        EmployeeDAO.filterEmployeeByName(company1.getId(), "Dragan");
        EmployeeDAO.filterEmployeeByName(company2.getId(), "Aira");

        //works
        System.out.println("-----------Employee's buildings-----------");
        EmployeeDAO.getEmployeeBuildings(employee1.getId());
        EmployeeDAO.getEmployeeBuildings(employee2.getId());
        EmployeeDAO.getEmployeeBuildings(employee3.getId());

        //works
        System.out.println("-----------Sort inhabitants by name-----------");
        InhabitantDAO.sortInhabitantsByName(building1.getId());
        InhabitantDAO.sortInhabitantsByName(building4.getId());

        //works
        System.out.println("-----------Filter inhabitants by name-----------");
        InhabitantDAO.filterInhabitantByName(building1.getId(), "Ivan");

        //works
        System.out.println("-----------Sort inhabitants by age-----------");
        InhabitantDAO.sortInhabitantsByAge(building1.getId());

        //works
        System.out.println("-----------Building's apartments - List and Count-----------");
        BuildingDAO.getBuildingApartments(building1.getId());
        BuildingDAO.getBuildingApartments(building2.getId());
        BuildingDAO.getBuildingApartments(building4.getId());

        //works
        System.out.println("-----------Building's inhabitants - List and Count-----------");
        BuildingDAO.getBuildingInhabitants(building1.getId());
        BuildingDAO.getBuildingInhabitants(building4.getId());

        //works
        System.out.println("-----------Building's paid sums - List and Count-----------");
        BuildingDAO.getBuildingPaidSums(building1.getId()).forEach(System.out::println);


//        PaymentDAO.makePayment(apartment1.getId(), apartment1.apartmentFee());
//        PaymentDAO.createPayment(payment3, payment3.getApartment().getId(), payment3.getApartment().apartmentFee());
//        PaymentDAO.createPayment(payment4, payment4.getApartment().getId(), payment4.getApartment().apartmentFee());


        System.out.println(apartment1.getInhabitants());
        System.out.println(apartment3.getInhabitants());
        System.out.println(apartment1.getPets());
        System.out.println(apartment1.getFee());
        //works
        PaymentDAO.createPayment(payment4, payment4.getApartment().getId(), payment4.getApartment().apartmentFee());

        //works
        String fileName = "C:\\Users\\USER\\IdeaProjects\\CSCB525\\HouseManager\\src\\main\\java\\files\\Payments.txt";
        writePaymentData(fileName, payment1);
        writePaymentData(fileName, payment2);
        writePaymentData(fileName, payment3);
        writePaymentData(fileName, payment4);

        //works
        CompanyDAO.findEmployeeWithLeastBuildings(building1.getId());

        //works
        //CompanyDAO.fireEmployee(building1.getId(), employee2.getId());
        //   CompanyDAO.fireEmployee(building1.getId(), employee3.getId());

        //System.out.println(payment4.getPaidSum());
        //CompanyDAO.contractEmployee(company3.getId(),building4.getId());
    }
}
