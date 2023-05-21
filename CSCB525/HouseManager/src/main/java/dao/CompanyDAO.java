package dao;

import configuration.SessionFactoryUtil;
import entity.Company;
import entity.Contract;
import entity.Employee;
import entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class CompanyDAO {
    public static void createCompany(Company company) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }

    public static void saveOrUpdateCompany(Company company) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

    public static void deleteCompany(Company company) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
        }
    }

    public static Company getCompanyById(long id) {
        Company company;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(Company.class, id);
            transaction.commit();
        }
        return company;
    }

    //--
    public static void companyIncomes(long companyID) {
        List<Payment> paymentList;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            paymentList = session.createQuery(
                            "select p from Payment as p" +
                                    " join p.apartment.id a" +
                                    " join a.building.id b" +
                                    " join b.contract.id c" +
                                    " join c.employee.id e" +
                                    " where e.company.id = :companyID"
                            , Payment.class)
                    .setParameter("companyID", companyID)
                    .getResultList();

            transaction.commit();
        }
        System.out.println(paymentList);
    }

    public static void fireEmployee(long companyID, long employeeID) {
        // check if the employee is in the company
        Employee firedEmployee;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            firedEmployee = session.createQuery(
                            "select e from Employee as e" +
                                    " where e.id = :employeeID", Employee.class)
                    .setParameter("employeeID", employeeID)
                    .getSingleResult();
            transaction.commit();


            // get Employee's buildings
            List<Contract> contractList = EmployeeDAO.getEmployeeBuildings(employeeID);

            // get the Employee with the least buildings
            Employee employee = CompanyDAO.findEmployeeWithLeastBuildings(companyID);
            long newEmployeeID = employee.getId();

            // update - При освобождаване от работа на служител, който има зачислени сгради, неговите сгради се разпределят на останалите служители.
            try (Session session1 = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction1 = session1.beginTransaction();

                int query = session1.createQuery(
                                "update Contract" +
                                        " set employee.id = :newEmployeeID" +
                                        " where employee.id = :employeeID")
                        .setParameter("newEmployeeID", newEmployeeID)
                        .setParameter("employeeID", employeeID)
                        .executeUpdate();
                transaction1.commit();
            }

            // delete the fired employee from DB
            try (Session session2 = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction2 = session2.beginTransaction();

                int query = session2.createQuery(
                                "delete from Employee as e" +
                                        " where e.id = :employeeID")
                        .setParameter("employeeID", employeeID)
                        .executeUpdate();
                transaction2.commit();
            }

            System.out.println("-----------The building is now operated by " + employee.getName() + ", id = " + newEmployeeID + "-----------");
        } catch (NoResultException e) {
            System.out.println("-----------Cannot fire employee with id = " + employeeID + " because not exists!-----------");
        }
    }

    public static Employee findEmployeeWithLeastBuildings(long companyID) {

        int lessBuildingsCount = 0;
        long employeeIDWithLeasBuildings = 0;
        String employeeName = "";
        Employee resultEmployee = new Employee();

        List<Employee> employeeList;

        // show all employees in the company
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employeeList = session.createQuery(
                            "select e from Employee as e" +
                                    " where e.company.id = :companyID"
                            , Employee.class)
                    .setParameter("companyID", companyID)
                    .getResultList();
            transaction.commit();
        }

        // find employee with least buildings
        for (Employee employee : employeeList) {
            long employeeID = employee.getId();
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                int count = session.createQuery(
                                "select count (c.building.id) from Contract as c" +
                                        " where c.employee.id = :employeeID")
                        .setParameter("employeeID", employeeID)
                        .getFirstResult();

                transaction.commit();
                if (count <= lessBuildingsCount) {
                    lessBuildingsCount = count;
                    employeeIDWithLeasBuildings = employeeID;
                    employeeName = employee.getName();
                    resultEmployee = employee;
                }
            }
        }

        System.out.println("-----------Employee " + employeeName + ",id = " + employeeIDWithLeasBuildings + " operates " + lessBuildingsCount + " buildings!-----------");
        return resultEmployee;
    }

    //--
    //При сключване на договор за обслужване на нова сграда, тя се разпределя на служителя с най-малко на брой зачислени                   сгради.
    public static void contractEmployee(long companyID, long buildingID) {
        // взимаме служителя с най-малко сгради
        Employee employee = CompanyDAO.findEmployeeWithLeastBuildings(companyID);
        long employeeID = employee.getId();

        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            int query = session.createQuery(
                            "insert into Contract" +
                                    " (employee.id, building.id ) values (:employeeID, :buildingID)")
                    .setParameter("employeeID", employeeID)
                    .setParameter("buildingID", buildingID)
                    .executeUpdate();
            transaction.commit();
        }
    }
}
