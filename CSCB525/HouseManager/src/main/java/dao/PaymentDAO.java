package dao;

import configuration.SessionFactoryUtil;
import entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.management.Query;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentDAO {

    //rename it to makePayment
    public static void createPayment(Payment payment, long apartmentID, BigDecimal paidSum) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(payment);

            // set apartment fee
            int query = session.createQuery(
                            "update Payment" +
                                    " set paidSum = :paidSum" +
                                    " where apartment.id = :apartmentID")
                    .setParameter("paidSum", paidSum)
                    .setParameter("apartmentID", apartmentID)
                    .executeUpdate();
            transaction.commit();
        }
    }

    public static void deletePayment(Payment payment) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(payment); // метод за изтриване -> ще изтрие записа от базата
            transaction.commit();
        }
    }

    public static void saveOrUpdatePayment(Payment payment) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(payment);
            transaction.commit();
        }
    }

    public static Payment getPaymentById(long id) {
        Payment payment;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            payment = session.get(Payment.class, id);
            transaction.commit();
        }
        return payment;
    }

    // don't need it
    public static void makePayment(long apartmentID, BigDecimal paidSum) {
        Payment payment;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            int query = session.createQuery(
                            "update Payment" +
                                    " set paidSum = :paidSum" +
                                    " where apartment.id = :apartmentID")
                    .setParameter("paidSum", paidSum)
                    .setParameter("apartmentID", apartmentID)
                    .executeUpdate();

            transaction.commit();
        }
    }
}

