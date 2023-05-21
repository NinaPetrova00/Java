package entity;

import configuration.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(1) //най-малко един етаж
    @Column(name = "floor", nullable = false)
    private int floor;

    @Min(1) // номерата на апартаментите започват от едно нагоре
    @Column(name = "number", nullable = false)
    private int number;

    @DecimalMin(value = "45.00") //минимално 45кв.м.
    @Column(name = "area", nullable = false)
    private BigDecimal area;

    @OneToMany(mappedBy = "apartment") // един апартамент, много жители
    private List<Inhabitant> inhabitants;

    @OneToMany(mappedBy = "apartment") // един апартамент, много животни
    private List<Pet> pets;

    @ManyToOne(fetch = FetchType.LAZY)// един собственик, много апартаменти
    @JoinColumn(name = "ownerID", nullable = false)
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)// една сграда, много апартаменти
    @JoinColumn(name = "buildingID", nullable = false)
    private Building building;

    @OneToOne(mappedBy = "apartment")
    private Fee fee;

    @OneToMany(mappedBy = "apartment") // един апартмент, много плащания на такси
    private List<Payment> payments;

    public Apartment() {
    }

    public Apartment(long id, int floor, int number, BigDecimal area, Owner owner, Building building) {
        this.id = id;
        this.floor = floor;
        this.number = number;
        this.area = area;
        this.owner = owner;
        this.building = building;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public List<Inhabitant> getInhabitants() {
        long apartmentID = this.id;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            inhabitants = session.createQuery(
                            "select i from Inhabitant as i" +
                                    " where i.apartment.id = :apartmentID", Inhabitant.class)
                    .setParameter("apartmentID", apartmentID)
                    .getResultList();

        }
        return inhabitants;
    }

    public void setInhabitants() {
        //  this.inhabitants = inhabitants;
        long apartmentID = this.id;
        List<Inhabitant> inhabitantList = new ArrayList<>();

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            inhabitantList = session.createQuery(
                            "select i from Inhabitants as i" +
                                    " where i.apartment.id = :apartmentID", Inhabitant.class)
                    .setParameter("apartmentID", apartmentID)
                    .getResultList();
            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("-----------No inhabitants-----------");
        }
        this.inhabitants = inhabitantList;
    }

    public List<Pet> getPets() {
        long apartmentID = this.id;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            pets = session.createQuery(
                            "select p from Pet as p" +
                                    " where p.apartment.id = :apartmentID", Pet.class)
                    .setParameter("apartmentID", apartmentID)
                    .getResultList();
        }
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Fee getFee() {
        long apartmentID = this.id;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            fee = session.createQuery(
                            "select f from Fee as f" +
                                    " where f.apartment.id = :apartmentID", Fee.class)
                    .setParameter("apartmentID", apartmentID)
                    .getSingleResult();
        }
        return fee;
    }

    public void setFee() {
        long apartmentID = this.id;
        Fee fee1 = new Fee();

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            fee1 = session.createQuery(
                            "select f from Fee as f" +
                                    " where f.apartment.id = :apartmentID", Fee.class)
                    .setParameter("apartmentID", apartmentID)
                    .getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("-----------No inhabitants-----------");
        }
        this.fee = fee1;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public BigDecimal apartmentFee() {
        Fee myFee = getFee();
        List<Pet> myPets = getPets();
        List<Inhabitant> myInhabitants = getInhabitants();

        System.out.println(myFee);
        BigDecimal finalFee = myFee.getFeePerSquareMeter().multiply(area);

        /*Ако в апартамента има домашен любимец, който използва общите част на сградата,
            се добавя и определена сума за него*/
        if (!myPets.isEmpty()) {
            //  finalFee += myFee.getPetFee();
            finalFee = finalFee.add(myFee.getPetFee()); // цена за едно животно

            int petsCount = myPets.size();
            //finalFee *= petsCount;
            finalFee = finalFee.multiply(BigDecimal.valueOf(petsCount));  // крайна цена за всичките животни
        }

        /*Допълнителна сума за всеки живущ*/
        for (Inhabitant inhabitant : myInhabitants) {

            /*който е на възраст над 7 години*/
            if (inhabitant.getAge() > 7) {
                //finalFee += myFee.getAgeFee();
                finalFee = finalFee.add(myFee.getAgeFee());
            }

            /*който използва асансьор*/
            if (inhabitant.useElevator) {
                //finalFee += myFee.getElevatorFee();
                finalFee = finalFee.add(myFee.getElevatorFee());
            }
        }

        return finalFee; /*крайна такса за апартамент*/
    }


    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", floor=" + floor +
                ", number=" + number +
                ", area=" + area +
                '}';
    }
}
