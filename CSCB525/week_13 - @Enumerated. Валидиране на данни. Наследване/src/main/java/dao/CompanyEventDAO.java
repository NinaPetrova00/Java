package dao;

import configuration.SessionFactoryUtil;
import entity.CompanyEvent;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyEventDAO {    public static void saveCompanyEvent(CompanyEvent company) {
    try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();
        session.save(company);
        transaction.commit();
    }
}



    public static void saveOrUpdateCompanyEvent(CompanyEvent company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

    public static void saveCompanies(List<CompanyEvent> companyList) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companyList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static List<CompanyEvent> readCompanies() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT c FROM entities.entity.CompanyEvent c", CompanyEvent.class).getResultList();
        }
    }

    public static CompanyEvent getCompanyEvent(long id) {
        CompanyEvent company;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(CompanyEvent.class, id);
            transaction.commit();
        }
        return company;
    }


    public static void deleteCompanyEvent(CompanyEvent company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
        }
    }

}



