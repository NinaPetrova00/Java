package dao;

import configuration.SessionFactoryUtil;
import entity.Contract;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContractDAO {
    public static void createContract(entity.Contract contract) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(contract);
            transaction.commit();
        }
    }

    public static void deleteContract(Contract contract) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(contract); // метод за изтриване -> ще изтрие записа от базата
            transaction.commit();
        }
    }

    public static void saveOrUpdateContract(Contract contract) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(contract);
            transaction.commit();
        }
    }

    public static Contract getContractById(long id) {
        Contract contract;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            contract = session.get(Contract.class, id);
            transaction.commit();
        }
        return contract;
    }
}
