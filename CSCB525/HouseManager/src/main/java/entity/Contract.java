
package entity;

import configuration.SessionFactoryUtil;
import dao.CompanyDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//   /* @Column(name = "feePerSquareMeter", nullable = false)
//    private double feePerSquareMeter; *//*цена за квадратен метър, според договора*//*
//
//    @Column(name = "ageFee", nullable = false)
//    private double ageFee;  *//*допълнителна сума за всеки живущ, който е на възраст над 7 години*//*
//
//    @Column(name = "elevatorFee", nullable = false)
//    private double elevatorFee;  *//*допълнителна сума за всеки живущ, койтоизползва асансьор*//*
//
//    @Column(name = "petFee", nullable = false)
//    private double petFee;   *//*цена за домашен любимец*/

    @OneToOne
    @JoinColumn(name = "buildingID", nullable = false, unique = true)
    private Building building;

    @ManyToOne // един служител, много договори
    @JoinColumn(name = "employeeID", nullable = false)
    private Employee employee;

    public Contract() {
    }

    public Contract(long id, Building building, Employee employee) {
        this.id = id;
        this.building = building;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Employee getEmployee() {
        long employeeID = this.employee.getId();

        Employee employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.createQuery(
                            "select c from Contract as c" +
                                    " where c.employee.id = :employeeID", Employee.class)
                    .setParameter("employeeID", employeeID)
                    .getSingleResult();
        }

        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;

    }

    public Contract(long id) {
        this.id = id;
    }
}







