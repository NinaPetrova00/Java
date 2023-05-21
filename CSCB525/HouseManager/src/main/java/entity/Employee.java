package entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Employee name cannot be blank!")
    @Pattern(regexp = "^([A-Z]).*", message = "Employee name has to start with capital letter!")
    @Column(name="name", nullable = false)
    private String name;

    @ManyToOne //една компания, много служители
    @JoinColumn(name="companyID", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "employee") // един служител, много договори
    private Set<Contract> contracts;

    public Employee() {
    }

    public Employee(long id, String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.contracts = new TreeSet<>();
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
