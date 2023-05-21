package entity;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Owner name cannot be blank!")
    @Pattern(regexp = "^([A-Z]).*", message = "Owner name has to start with capital letter!")
    @Column(name="name", nullable = false)
    private String name;

    @PastOrPresent(message = "Birth date cannot be in the future!")
    @Column(name="birthDate")
    private LocalDate birthDate;

    // такава колона в таблицата няма да има, тя просто изчислява възрастта спрямо сегашната година и birthDate
    @Formula(value = "YEAR(NOW())-YEAR(birthDate)")
    private int age;

    @Column(name="isInhabitant")
    private boolean isInhabitant;

    @OneToMany(mappedBy = "owner")  // един собственик, много апартаменти
    private List<Apartment> apartments;

    public Owner() {
    }

    public Owner(long id, String name, LocalDate birthDate, boolean isInhabitant) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.isInhabitant = isInhabitant;
        this.apartments = new ArrayList<>();
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isInhabitant() {
        return isInhabitant;
    }

    public void setInhabitant(boolean inhabitant) {
        isInhabitant = inhabitant;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", isInhabitant=" + isInhabitant +
                '}';
    }
}
