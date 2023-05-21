package dao;

import configuration.SessionFactoryUtil;
import dto.CompanyDTO;
import dto.EmployeeDTO;
import entity.Company;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CompanyDAO {

    public static void saveCompany(entity.Company company) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }

    public static void saveOrUpdateCompany(entity.Company company) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

    public static void saveCompanies(List<Company> companyList) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companyList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static List<Company> readCompanies() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT c FROM entities.entity.Company c", entity.Company.class).getResultList();
        }
    }

    public static entity.Company getCompany(long id) {
        entity.Company company;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(entity.Company.class, id);
            transaction.commit();
        }
        return company;
    }

    //Решаване на проблема lazy initialize exception
    // заявка, която включва join fetch
    // join fetch -> ще свърже обекта company с обекта employee и служи
    // да се заредят в обекта company стойностите за employee
    public static List<Employee> getCompanyEmployees(long id) {
        Company company;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.createQuery(
                            "select c from Company c" + // казваме на база на какво е връзката
                                    " join fetch c.employees" + // c.employees е това, което сме посочили в company като поле за връзката между двете
                                    " where c.id = :id", // параметризирана заявка, на която мога да подавам много параметри
                            Company.class) // в резултат получваме един обект от тип  Company.class
                    .setParameter("id", id) // "ид" трябва да съвпада с етикета след двуеточието при where клаузата
                    .getSingleResult(); // метод за завършване на заявката - getSingleResult/resultList
            transaction.commit();
        }
        return company.getEmployees();
    }

    //DTO - data transfer object
    //ще върне служителите
    public static List<EmployeeDTO> getCompanyEmployeesDTO(long id) {
        List<EmployeeDTO> employees; //връщам employeeDTO, което означва, че не работим с Employee обектите, а с EmployeeDTO
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery( //селектира се от Employee, но се прави обект от тип EmployeeDTO и той се връща
                            "select new dto.EmployeeDTO(e.id, e.name) from Employee e" + //dto.EmployeeDTO - конструктор
                                    " join e.company c " + //id, name - тези стойности идват от таблицата в базата Employee
                                    "where c.id = :id",
                            EmployeeDTO.class)
                    .setParameter("id", id)
                    .getResultList(); // получавам директно лист от EmployeeDTO, селектирайки от Employee
            transaction.commit();
        }
        return employees;
    }

    public static void deleteCompany(entity.Company company) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
        }
    }

    public static List<Company> companiesWithInitialCapitalGreaterThan(double initialCapital) {
        // select * from company where initial_capital > 6000
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(entity.Company.class);
            Root<Company> root = criteriaQuery.from(entity.Company.class);
            criteriaQuery.select(root).where(criteriaBuilder.greaterThan(root.get("initialCapital"), initialCapital));

            Query<Company> query = session.createQuery(criteriaQuery);
            List<Company> companies = query.getResultList();

            return companies;
        }
    }

    public static List<Company> companiesWithInitialCapitalBetween(double top, double bottom) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(entity.Company.class);
            Root<Company> root = cr.from(entity.Company.class);
            cr.select(root).where(cb.between(root.get("initialCapital"), top, bottom));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static BigDecimal maxInitialCapital() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<BigDecimal> cr = cb.createQuery(BigDecimal.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(cb.max(root.get("initialCapital")));

            Query<BigDecimal> query = session.createQuery(cr);
            BigDecimal maxInitialCapital = query.getSingleResult();
            return maxInitialCapital;
        }
    }

    public static BigDecimal sumInitialCapital() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<BigDecimal> cr = cb.createQuery(BigDecimal.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(cb.sum(root.get("initialCapital")));

            Query<BigDecimal> query = session.createQuery(cr);
            BigDecimal maxInitialCapital = query.getSingleResult();
            return maxInitialCapital;
        }
    }

    public static List<Company> companiesWithNameEqualTo(String name) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.equal(root.get("name"), name));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> companiesWithNameNotEqualTo(String name) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.notEqual(root.get("name"), name));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> companiesWithNameLike(String name) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.like(root.get("name"), "%" + name + "%"));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> companiesWithNameNotLike(String name) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.notLike(root.get("name"), "%" + name + "%"));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> companiesWithNameStartingWithAndInitialCapitalGreaterThan(String name, double initialCapital) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);

            Predicate greaterThanInitialCapital = cb.greaterThan(root.get("initialCapital"), initialCapital);
            Predicate nameStartingWith = cb.like(root.get("name"), name + "%");

            cr.select(root).where(cb.and(greaterThanInitialCapital, nameStartingWith));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> companiesByNameAscAndInitialCapitalDesc() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.orderBy(cb.asc(root.get("initialCapital")), cb.desc(root.get("name")));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> companiesWithFoundationDateGreaterThan(LocalDate localDate) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.greaterThan(root.get("foundationDate"), localDate));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

}



