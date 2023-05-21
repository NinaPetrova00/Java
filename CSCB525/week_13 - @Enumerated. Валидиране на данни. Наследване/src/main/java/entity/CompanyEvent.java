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

    // не искаме да е обикновена колона, а искаме да е Enumerated
    // в базата пак се пази като колона, но има ограничения от това какви данни да има вътре в нея
    // ORDINAL - default enum type when using @Enumerated
    //@Enumerated(EnumType.ORDINAL) ORDINAL - пореден номер на константата, която е записана в тип изброим
    @Enumerated(EnumType.STRING)
    private CompanyEventType companyEventType;

    @ManyToMany
    private Set<Employee> employees;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public CompanyEventType getCompanyEventType() {
        return companyEventType;
    }

    public void setCompanyEventType(CompanyEventType companyEventType) {
        this.companyEventType = companyEventType;
    }

    @Override
    public String toString() {
        return "CompanyEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyEventType=" + companyEventType +
                '}';
    }
}
