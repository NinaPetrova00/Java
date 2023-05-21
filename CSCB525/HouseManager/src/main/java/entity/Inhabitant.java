package entity;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name = "inhabitant")
public class Inhabitant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Inhabitant name cannot be blank!")
    @Pattern(regexp = "^([A-Z]).*", message = "Inhabitant name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @PastOrPresent(message = "Birth date cannot be in the future!")
    @Column(name = "birthDate")
    private LocalDate birthDate;

    // такава колона в таблицата няма да има, тя просто изчислява възрастта спрямо сегашната година и birthDate
    @Formula(value = "YEAR(NOW())-YEAR(birthDate)")
    private int age;

    @Column(name = "useElevator")
    public boolean useElevator;

    @ManyToOne(fetch = FetchType.LAZY)// един апартамент, много жители
    @JoinColumn(name = "apartmentID", nullable = false)
    private Apartment apartment;

    public Inhabitant() {
    }

    public Inhabitant(long id, String name, LocalDate birthDate, boolean useElevator, Apartment apartment) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.useElevator = useElevator;
        this.apartment = apartment;
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

    public boolean isUseElevator() {
        return useElevator;
    }

    public void setUseElevator(boolean useElevator) {
        this.useElevator = useElevator;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Inhabitant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", useElevator=" + useElevator +
                '}';
    }
}
