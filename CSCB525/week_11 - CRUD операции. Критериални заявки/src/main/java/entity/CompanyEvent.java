package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CompanyEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    private Set<entity.Employee> employees;

}
