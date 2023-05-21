package entity;

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

    @ManyToOne
    private entity.Company company;

    @ManyToMany(mappedBy = "employees")
    private Set<CompanyEvent> companyEvents;
}
