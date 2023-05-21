package entity;

import org.hibernate.action.internal.OrphanRemovalAction;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "employee")
    private IdentityCard identityCard;

    @ManyToOne (fetch = FetchType.LAZY)
    private entity.Company company;

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
                ", identityCard=" + identityCard +
                '}';
    }
}
