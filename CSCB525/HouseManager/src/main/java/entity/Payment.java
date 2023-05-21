package entity;

import configuration.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @PastOrPresent(message = "Payment date cannot be in the future!")
    @Column(name = "paymentDate")
    private LocalDate paymentDate;

    @ManyToOne // един апартмент, много плащания на такси
    @JoinColumn(name = "apartmentID", nullable = false)
    private Apartment apartment;

    @Column(name = "paidSum")
    private BigDecimal paidSum;

    public Payment() {
    }

    public Payment(long id, LocalDate paymentDate, Apartment apartment) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.apartment = apartment;
    }

    public long getId() {
        return id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public BigDecimal getPaidSum() {
        long apartmentID = this.apartment.getId();

        List<BigDecimal> sumList;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            sumList = session.createQuery(
                            "select paidSum from Payment as p" +
                                    " where p.apartment.id = :apartmentID", BigDecimal.class)
                    .setParameter("apartmentID", apartmentID)
                    .getResultList();
        }

        return sumList.get(0);
    }

    public void setPaidSum(BigDecimal paidSum) {
        // this.paidSum = this.apartment.apartmentFee();
        this.paidSum = paidSum;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentDate=" + paymentDate +
                ", apartment=" + apartment +
                ", paidSum=" + paidSum +
                '}';
    }
}
