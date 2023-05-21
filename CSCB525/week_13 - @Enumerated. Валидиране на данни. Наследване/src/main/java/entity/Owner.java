package entity;

import javax.persistence.*;

@Entity
@Table(name = "owner")
@DiscriminatorValue("owner")
public class Owner extends Person {

    // ако не направя id, това означава, че Owner ще си взема id-то от Person

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Owner() {
    }

    public Owner(String name) {
        this.name = name;
    }

    public Owner(long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
