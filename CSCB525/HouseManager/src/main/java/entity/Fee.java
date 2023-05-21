package entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "fee")
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Positive
    @Column(name = "feePerSquareMeter", nullable = false)
    private BigDecimal feePerSquareMeter; /*цена за квадратен метър, според договора*/

    @Positive
    @Column(name = "ageFee", nullable = false)
    private BigDecimal ageFee;  /*допълнителна сума за всеки живущ, който е на възраст над 7 години*/

    @Positive
    @Column(name = "elevatorFee", nullable = false)
    private BigDecimal elevatorFee;  /*допълнителна сума за всеки живущ, койтоизползва асансьор*/

    @Positive
    @Column(name = "petFee", nullable = false)
    private BigDecimal petFee;   /*цена за домашен любимец*/

    @OneToOne
    @JoinColumn(name = "apartmentID", nullable = false, unique = true)
    private Apartment apartment;

    public Fee() {
    }

    public Fee(long id, BigDecimal feePerSquareMeter, BigDecimal ageFee, BigDecimal elevatorFee, BigDecimal petFee, Apartment apartment) {
        this.id = id;
        this.feePerSquareMeter = feePerSquareMeter;
        this.ageFee = ageFee;
        this.elevatorFee = elevatorFee;
        this.petFee = petFee;
        this.apartment = apartment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getFeePerSquareMeter() {
        return feePerSquareMeter;
    }

    public void setFeePerSquareMeter(BigDecimal feePerSquareMeter) {
        this.feePerSquareMeter = feePerSquareMeter;
    }

    public BigDecimal getAgeFee() {
        return ageFee;
    }

    public void setAgeFee(BigDecimal ageFee) {
        this.ageFee = ageFee;
    }

    public BigDecimal getElevatorFee() {
        return elevatorFee;
    }

    public void setElevatorFee(BigDecimal elevatorFee) {
        this.elevatorFee = elevatorFee;
    }

    public BigDecimal getPetFee() {
        return petFee;
    }

    public void setPetFee(BigDecimal petFee) {
        this.petFee = petFee;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "id=" + id +
                ", feePerSquareMeter=" + feePerSquareMeter +
                ", ageFee=" + ageFee +
                ", elevatorFee=" + elevatorFee +
                ", petFee=" + petFee +
                ", apartment=" + apartment +
                '}';
    }
}
