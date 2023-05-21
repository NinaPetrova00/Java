package entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // валидациите идват от пакета import javax.validation.constraints.*;
    @NotBlank(message = "Company name cannot be blank!") // колоната е notNull, но стойнстта е notBlank
    @Size(max = 20, message = "Company name has to be with up to 20 characters!")
    // определя дължината - можем да кажем мин и макс; работи не само върху стрингови данни
    @Pattern(regexp = "^([A-Z]).*", message = "Company name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @Positive
    // за BigDecimal се използва DecimalMin/Max - за другите числови стойности е по стандартен начин със @Size
    @DecimalMin(value = "5000.00", message = "Initial capital has to be more than or equal to 5000.00", inclusive = true)
    @DecimalMax(value = "10000.00", message = "Initial capital has to be less than or equal to 10000.00")
    // колко цифири преди и след десетичния разделител
    @Digits(integer = 5, fraction = 2, message = "Initial capital has to be with 5 digits before and 2 digits after the decimal separator!")
    @Column(name = "initial_capital", nullable = false)
    private BigDecimal initialCapital;

    @PastOrPresent(message = "Foundation date cannot be in the future!")
    @Column(name = "foundation_date")
    private LocalDate foundationDate;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    public Company() {
    }

    public Company(String name, String address, BigDecimal initialCapital, LocalDate foundationDate) {
        this.name = name;
        this.address = address;
        this.initialCapital = initialCapital;
        this.foundationDate = foundationDate;
    }

    public Company(long id, String name, String address, BigDecimal initialCapital, LocalDate foundationDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.initialCapital = initialCapital;
        this.foundationDate = foundationDate;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", initialCapital=" + initialCapital +
                ", foundationDate=" + foundationDate +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
