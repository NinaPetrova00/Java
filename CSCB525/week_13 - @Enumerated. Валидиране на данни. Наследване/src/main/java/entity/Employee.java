package entity;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("employee")
public class Employee extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="birth_date")
    private LocalDate birthDate;

    // такава колона в таблицата няма да има, тя просто изчислява възрастта спрямо сегашната година и birthDate
    @Formula(value = "YEAR(NOW())-YEAR(birth_date)")
    private int age;

    @OneToOne(mappedBy = "employee")
    private IdentityCard identityCard;

    @ManyToOne (fetch = FetchType.LAZY)
    private Company company;

    @ManyToMany(mappedBy = "employees")
    private Set<CompanyEvent> companyEvents;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    public Company getCompany() {
        return company;
    }

    public Set<CompanyEvent> getCompanyEvents() {
        return companyEvents;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", identityCard=" + identityCard +
                '}';
    }
}
