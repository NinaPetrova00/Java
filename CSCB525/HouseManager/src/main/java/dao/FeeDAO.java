package dao;

import configuration.SessionFactoryUtil;
import entity.Fee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FeeDAO {
    public static void createFee(entity.Fee fee) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(fee);
            transaction.commit();
        }
    }

    public static void deleteFee(Fee fee) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(fee); // метод за изтриване -> ще изтрие записа от базата
            transaction.commit();
        }
    }

    public static void saveOrUpdateFee(Fee fee) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(fee);
            transaction.commit();
        }
    }

    public static Fee getFeeById(long id) {
        Fee fee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            fee = session.get(Fee.class, id);
            transaction.commit();
        }
        return fee;
    }
}
