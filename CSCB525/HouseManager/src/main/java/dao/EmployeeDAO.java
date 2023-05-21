package dao;

import configuration.SessionFactoryUtil;
import entity.Building;
import entity.Contract;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class EmployeeDAO {
    public static void createEmployee(entity.Employee employee) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    public static void deleteEmployee(Employee employee) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee); // метод за изтриване -> ще изтрие записа от базата
            transaction.commit();
        }
    }

    public static void saveOrUpdateEmployee(Employee employee) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }

    public static Employee getEmployeeById(long id) {
        Employee employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }
        return employee;
    }

    // Сортиране на служителите на компанията по име
    public static List<Employee> sortEmployeesByName(long companyID) {
        List<Employee> sortedEmployees;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            sortedEmployees = session.createQuery(
                            "select e from Employee as e" +
                                    " where e.company.id = :companyID" +
                                    " order by e.name", Employee.class)
                    .setParameter("companyID", companyID)
                    .getResultList();

            System.out.println("-----------Sorted employees by name in company with id=" + companyID + "-----------");
            if (sortedEmployees.isEmpty()) {
                System.out.println("-----------No employees in the company!-----------");
            } else {
                for (Employee e : sortedEmployees) {
                    System.out.println(e.getName());
                }
            }
            transaction.commit();
        }
        return sortedEmployees;
    }

    // Филтриране на служителите на компанията по име
    public static List<Employee> filterEmployeeByName(long companyID, String employeeName) {
        List<Employee> filteredEmployees;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            filteredEmployees = session.createQuery(
                            "select e from Employee as e" +
                                    " where e.company.id = :companyID and e.name = :employeeName" +
                                    " order by e.name", Employee.class)
                    .setParameter("companyID", companyID)
                    .setParameter("employeeName", employeeName)
                    .getResultList();

            System.out.println("----------- Filter employees by name=" + employeeName + " in company with id=" + companyID + " -----------");
            if (filteredEmployees.isEmpty()) {
                System.out.println("No employee with name " + employeeName + " in the company!");
            } else {
                for (Employee e : filteredEmployees) {
                    System.out.println(e.getName() + ", id=" + e.getId());
                }
            }
            transaction.commit();
        }
        return filteredEmployees;
    }


    // връща сградите+броят им, обслужвани от служителя
    public static List<Contract> getEmployeeBuildings(long employeeID) {
        List<Contract> contractList;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            contractList = session.createQuery(
                            "select c from Contract as c" +
                                    " where c.employee.id = :employeeID", Contract.class)
                    .setParameter("employeeID", employeeID)
                    .getResultList();

            System.out.println("----------- Buildings operated by employee with id=" + employeeID + " -----------");

            if (contractList.isEmpty()) {
                System.out.println("----------- No buildings operated by employee with id=" + employeeID + "! -----------");
            } else {
                System.out.println("----------- Buildings' count -----------");
                System.out.println(contractList.size());
                System.out.println("----------- Buildings -----------");
                for (Contract b : contractList) {
                    System.out.println(b.getBuilding());
                }
            }
            transaction.commit();
        }
        return contractList;
    }

}
