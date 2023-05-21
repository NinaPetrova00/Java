package dao;

import configuration.SessionFactoryUtil;
import entity.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class CompanyDAO {

    // CREATE /save, създай/
    public static void saveCompany(entity.Company company) {
        //try-block: служи за, да може да се затвори сесията автоматично
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }

    // търсим дали има такова id в таблицата - ако има се update-ва/обновява/, ако няма се save-ва/създава/ ново
    // много често тези две операции са заедно и заради това се казва по този начин метода - saveOrUpdate
    public static void saveOrUpdateCompany(Company company) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

    // CREATE
    public static void saveCompanies(List<Company> companyList) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companyList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static List<Company> readCompanies() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM entities.Company a", entity.Company.class).getResultList();
        }
    }

    // READ AND GET
    public static Company getCompany(long id) {
        Company company; // резултата от session.get
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(Company.class, id); // кой е класа, който се използва и на кой принцип става селектирането - id
            transaction.commit();
        }
        return company; //връщаме резултата
    }

    // DELETE
    public static void deleteCompany(Company company) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(company); // метод за изтриване -> ще изтрие записа от базата
            transaction.commit();
        }
    }

    // критериална заявка
    public static List<Company> companiesWithInitialCapitalGreaterThan(double initialCapital) {
        // select * from company where initial_capital > 6000 -> native sequel
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            // interface from java persistence criteria
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            // query заявка, която се задава чрез builder-a
            CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class); // ще работя с клас Company

            // коя таблица ще се селектира -> Company
            Root<Company> root = criteriaQuery.from(Company.class);

            // тук правим SELECT
            // select(root) -> select * from // root е свързан с company
            // where -> where()
            // критериалната заявка в случая '>' -> criteriaBuilder.greaterThan <-> вграден метод в интерфейса criteriaBuilder
            // greaterThan -> първо слагаме критерия, от който зависи "initialCapital" и после слагаме стойността
            criteriaQuery.select(root).where(criteriaBuilder.greaterThan(root.get("initialCapital"), initialCapital));

            //стандартна заявка, не е критериална
            Query<Company> query = session.createQuery(criteriaQuery); // тук подавам критериалната заявка

            // резултата от заявката
            List<Company> companies = query.getResultList();

            return companies;
        }
    }

    public static List<Company> companiesWithInitialCapitalBetween(double top, double bottom) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
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

}
