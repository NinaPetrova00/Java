package dao;

import configuration.SessionFactoryUtil;
import entity.Apartment;
import entity.Building;
import entity.Inhabitant;
import entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BuildingDAO {
    public static void createBuilding(entity.Building building) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(building);
            transaction.commit();
        }
    }

    public static void deleteBuilding(Building building) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(building);
            transaction.commit();
        }
    }

    public static void saveOrUpdateBuilding(Building building) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(building);
            transaction.commit();
        }
    }

    public static Building getBuildingById(long id) {
        Building building;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            building = session.get(Building.class, id);
            transaction.commit();
        }
        return building;
    }

    public static List<Apartment> getBuildingApartments(long buildingID) {
        Building building = new Building();

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            building = session.createQuery(
                            "select b from Building b" +
                                    " join fetch b.apartments" +
                                    " where b.id = :buildingID", Building.class)
                    .setParameter("buildingID", buildingID)
                    .getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("-----------No apartments in building with id=" + buildingID + " -----------");
            return null;
        }

        System.out.println("-----------Apartments' count in building with id=" + buildingID + " -----------");
        System.out.println(building.getApartments().size());
        System.out.println("-----------Apartments in building with id=" + buildingID + " -----------");
        System.out.println(building.getApartments());
        return building.getApartments();
    }

    public static List<Inhabitant> getBuildingInhabitants(long buildingID) {
        Apartment apartment;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartment = session.createQuery(
                            "select a from Apartment as a" +
                                    " join fetch a.inhabitants" +
                                    " where a.id = :buildingID", Apartment.class)
                    .setParameter("buildingID", buildingID)
                    .getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("-----------No inhabitants in building with id=" + buildingID + " -----------");
            return null;
        }

        System.out.println("-----------Inhabitants' count in building with id=" + buildingID + " -----------");
        System.out.println(apartment.getInhabitants().size());
        System.out.println("-----------Inhabitants in building with id=" + buildingID + " -----------");
        System.out.println(apartment.getInhabitants());

        return apartment.getInhabitants();
    }

    public static List<Payment> getBuildingPaidSums(long buildingID) {
        Apartment apartment;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartment = session.createQuery(
                            "select a from Apartment as a" +
                                    " join fetch a.payments" +
                                    " where a.id = :buildingID", Apartment.class)
                    .setParameter("buildingID", buildingID)
                    .getSingleResult();
            transaction.commit();
        }
        System.out.println("-----------Show building's paid sum count-----------");
        System.out.println(apartment.getPayments().size());
        System.out.println("-----------Paid sums for building with id=" + buildingID + " -----------");
        return apartment.getPayments();
    }
}
