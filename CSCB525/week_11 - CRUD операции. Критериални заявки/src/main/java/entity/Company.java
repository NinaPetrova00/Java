package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="initial_capital")
    private BigDecimal initialCapital;

    @Column(name="foundation_date")
    private LocalDate foundationDate;

    @OneToMany (mappedBy = "company")
    private List<Employee> employees;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Company(long id, String name, String address, BigDecimal initialCapital, LocalDate foundationDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.initialCapital = initialCapital;
        this.foundationDate = foundationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getInitialCapital() {
        return initialCapital;
    }

    public void setInitialCapital(BigDecimal initialCapital) {
        this.initialCapital = initialCapital;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", initialCapital=" + initialCapital +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
