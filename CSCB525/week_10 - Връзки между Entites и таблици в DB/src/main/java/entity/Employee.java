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

    @OneToOne(mappedBy = "employee") // казвам, че връзката се управлява/създадена от страната на identity card
    private IdentityCard identityCard; // полето в identity card, което се грижи за този процес се казва employee

    @ManyToOne //служителите са много, а компанията е една
    private Company company;

    @ManyToMany(mappedBy = "employees") // мапнато от страната на CompanyEvent
    private Set<CompanyEvent> companyEvents; // Set -> unique objects
}
