package dao;

import configuration.SessionFactoryUtil;
import entity.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDAO {

    /* запазвам компанията*/
    public static void saveCompany(Company company) {
        /* отварям нова сесия*/
        /* сесията се прави веднъж за целия проект*/
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            /* save - метод, който наготво дава възможността да правим запис, той ни осугурява insert-a*/
            session.save(company);
            transaction.commit();
        }
    }

    public static void saveCompanies(List<Company> companyList) {
        /* отварям нова сесия*/
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            /* на всяка компания, която се намери в този списък - session.save*/
            companyList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static List<Company> readCompanies() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Company a", Company.class).getResultList();
            /* createQuery - метод, който ни осигурява възможността ние да си напишем заявката*/
            /* свързвам резултата "а" с класа Компания*/
            /* връща ми се списък във формат под формата на компании*/
            /* getResultList - на createQuery да вземе изпълнението на тази заявка под формата на резултатен списък*/
        }
    }
}
