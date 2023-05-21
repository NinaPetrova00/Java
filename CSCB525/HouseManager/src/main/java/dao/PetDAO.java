package dao;

import configuration.SessionFactoryUtil;
import entity.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PetDAO {

    public static void createPet(entity.Pet pet) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pet);
            transaction.commit();
        }
    }

    public static void deletePet(Pet pet) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(pet);
            transaction.commit();
        }
    }

    public static void saveOrUpdatePet(Pet pet) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(pet);
            transaction.commit();
        }
    }

    public static Pet getPetById(long id) {
        Pet pet;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            pet = session.get(Pet.class, id);
            transaction.commit();
        }
        return pet;
    }
}
