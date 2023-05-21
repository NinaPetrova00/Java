package entity;

import javax.persistence.*;

@Entity
public class IdentityCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="place", nullable = false)
    private String place;

    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false, unique = true)
    @MapsId
    private entity.Employee employee;
}
