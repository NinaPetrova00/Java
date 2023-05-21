package dao;

import configuration.SessionFactoryUtil;
import entity.Apartment;
import entity.Inhabitant;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class InhabitantDAO {
    public static void createInhabitant(entity.Inhabitant inhabitant) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(inhabitant);
            transaction.commit();
        }
    }

    public static void deleteInhabitant(Inhabitant inhabitant) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(inhabitant); // метод за изтриване -> ще изтрие записа от базата
            transaction.commit();
        }
    }

    public static void saveOrUpdateInhabitant(Inhabitant inhabitant) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(inhabitant);
            transaction.commit();
        }
    }

    public static Inhabitant getInhabitantById(long id) {
        Inhabitant inhabitant;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            inhabitant = session.get(Inhabitant.class, id);
            transaction.commit();
        }
        return inhabitant;
    }

    public static List<Inhabitant> sortInhabitantsByName(long buildingID) {
        List<Inhabitant> sortedInhabitants = new ArrayList<>();
        List<Apartment> apartmentList;

        // get all apartments in the building
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartmentList = session.createQuery(
                            "select a from Apartment as a" +
                                    " where a.building.id = :buildingID", Apartment.class)
                    .setParameter("buildingID", buildingID)
                    .getResultList();
            transaction.commit();
        }

        if (apartmentList.isEmpty()) {
            System.out.println("----------- No inhabitants in building with id=" + buildingID + " -----------");
        } else {
//            System.out.println("----------- Sorted inhabitants by name in building with id=" + buildingID + " -----------");
            for (Apartment a : apartmentList) {
                long apartmentID = a.getId();
                try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                    Transaction transaction = session.beginTransaction();
                    sortedInhabitants = session.createQuery(
                                    "select i from Inhabitant as i" +
                                            " where i.apartment.id = :apartmentID" +
                                            " order by i.name", Inhabitant.class)
                            .setParameter("apartmentID", apartmentID)
                            .getResultList();

                    if (!sortedInhabitants.isEmpty()) {
                        System.out.println("----------- Sorted inhabitants by name in building with id=" + buildingID + " -----------");
                        System.out.println("----------- Inhabitants in apartment " + a.getNumber() + "-----------");
                        for (Inhabitant i : sortedInhabitants) {
                            System.out.println(i.getName());
                        }
                    }

                    transaction.commit();
                }
            }
        }

        return sortedInhabitants;
    }

    public static List<Inhabitant> filterInhabitantByName(long buildingID, String inhabitantName) {
        List<Inhabitant> filteredInhabitants = new ArrayList<>();
        List<Apartment> apartmentList;

        // get all apartments in the building
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartmentList = session.createQuery(
                            "select a from Apartment as a" +
                                    " where a.building.id = :buildingID", Apartment.class)
                    .setParameter("buildingID", buildingID)
                    .getResultList();
            transaction.commit();
        }

        if (apartmentList.isEmpty()) {
            System.out.println("-----------No inhabitants in building with id=" + buildingID + "-----------");
        } else {
            for (Apartment a : apartmentList) {
                long apartmentID = a.getId();
                try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                    Transaction transaction = session.beginTransaction();
                    filteredInhabitants = session.createQuery(
                                    "select i from Inhabitant as i" +
                                            " where i.apartment.id = :apartmentID and i.name = :inhabitantName" +
                                            " order by i.name", Inhabitant.class)
                            .setParameter("apartmentID", apartmentID)
                            .setParameter("inhabitantName", inhabitantName)
                            .getResultList();

                    if (!filteredInhabitants.isEmpty()) {
                        System.out.println("-----------Filtered inhabitants by name=" + inhabitantName + " in building with id=" + buildingID + "-----------");
                        System.out.println("-----------Inhabitants with name=" + inhabitantName + " in apartment " + a.getNumber() + "---------- - ");
                        for (Inhabitant i : filteredInhabitants) {
                            System.out.println(i.getName() + ", id=" + i.getId());
                        }
                    }
                    transaction.commit();
                }
            }
        }
        return filteredInhabitants;
    }

    public static List<Inhabitant> sortInhabitantsByAge(long buildingID) {
        List<Inhabitant> sortedInhabitants = new ArrayList<>();
        List<Apartment> apartmentList;

        // get all apartments in the building
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            apartmentList = session.createQuery(
                            "select a from Apartment as a" +
                                    " where a.building.id = :buildingID", Apartment.class)
                    .setParameter("buildingID", buildingID)
                    .getResultList();
            transaction.commit();
        }

        if (apartmentList.isEmpty()) {
            System.out.println("-----------No inhabitants in building with id=" + buildingID + "-----------");
        } else {
            for (Apartment a : apartmentList) {
                long apartmentID = a.getId();
                try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                    Transaction transaction = session.beginTransaction();
                    sortedInhabitants = session.createQuery(
                                    "select i from Inhabitant as i" +
                                            " where i.apartment.id = :apartmentID" +
                                            " order by i.birthDate desc", Inhabitant.class)
                            .setParameter("apartmentID", apartmentID)
                            .getResultList();

                    if (!sortedInhabitants.isEmpty()) {
                        System.out.println("-----------Sorted inhabitants by age in building with id=" + buildingID + "-----------");
                        System.out.println("-----------Inhabitants in apartment " + a.getNumber() + "-----------");
                        for (Inhabitant i : sortedInhabitants) {
                            System.out.println(i.getName() + ", age=" + i.getAge());
                        }
                    }

                    transaction.commit();
                }
            }
        }

        return sortedInhabitants;
    }

}
