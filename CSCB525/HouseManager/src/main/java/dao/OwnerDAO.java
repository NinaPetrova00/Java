package dao;

import configuration.SessionFactoryUtil;
import entity.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class OwnerDAO {
    public static void createOwner(entity.Owner owner) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(owner);
            transaction.commit();
        }
    }

    public static void deleteOwner(Owner owner) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(owner); // метод за изтриване -> ще изтрие записа от базата
            transaction.commit();
        }
    }

    public static void saveOrUpdateOwner(Owner owner) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(owner);
            transaction.commit();
        }
    }

     public static Owner getOwnerById(long id) {
        Owner owner;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            owner = session.get(Owner.class, id);
            transaction.commit();
        }
        return owner;
    }
}
