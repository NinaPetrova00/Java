package entity;

import javax.persistence.*;

@Entity
public class IdentityCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="place", nullable = false)
    private String place;

    //JoinColumn - как се осъществява връзката
    @OneToOne //прави външния ключ
    @JoinColumn(name = "employee_id", nullable = false, unique = true) //избираме свойствата на колоната външен ключ
    @MapsId // външният ключ да се превърне и в първичен ключ
    private Employee employee;
}
