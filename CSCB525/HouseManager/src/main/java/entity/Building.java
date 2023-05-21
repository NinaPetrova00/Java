package entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Building address cannot be blank!")
    @Pattern(regexp = "^([A-Z]).*", message = "Building address has to start with capital letter!")
    @Column(name="address", nullable = false)
    private String address; /*адрес*/

    @Min(1)
    @Column(name="floors", nullable = false)
    private int floors; /*брой етажи*/

    @DecimalMin(value = "150.00") //минимално 150кв.м.
    @Column(name="builtUpArea", nullable = false)
    private BigDecimal builtUpArea; /*застроена площ*/

    @DecimalMin(value = "10.00") //минимално 10кв.м.
    @Column(name="commonParts", nullable = false)
    private BigDecimal commonParts; /*общи части*/

    @Min(2) // най-малко два апартамента, иначе 1 апартамен=къща
    @Column(name="numberOfApartments", nullable = false)
    private int numberOfApartments; /*брой апартаменти*/

    @OneToMany(mappedBy = "building") // една сграда, много апартаменти
    private List<Apartment> apartments;

    @OneToOne(mappedBy = "building")
    private Contract contract;

    public Building() {
    }

    public Building(long id, String address, int floors, BigDecimal builtUpArea, BigDecimal commonParts, int numberOfApartments) {
        this.id = id;
        this.address = address;
        this.floors = floors;
        this.builtUpArea = builtUpArea;
        this.commonParts = commonParts;
        this.numberOfApartments = numberOfApartments;
        this.apartments = new ArrayList<>();
        this.contract = new Contract();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public BigDecimal getBuiltUpArea() {
        return builtUpArea;
    }

    public void setBuiltUpArea(BigDecimal builtUpArea) {
        this.builtUpArea = builtUpArea;
    }

    public BigDecimal getCommonParts() {
        return commonParts;
    }

    public void setCommonParts(BigDecimal commonParts) {
        this.commonParts = commonParts;
    }

    public int getNumberOfApartments() {
        return numberOfApartments;
    }

    public void setNumberOfApartments(int numberOfApartments) {
        this.numberOfApartments = numberOfApartments;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", floors=" + floors +
                ", builtUpArea=" + builtUpArea +
                ", commonParts=" + commonParts +
                ", numberOfApartments=" + numberOfApartments +
                ", contract=" + contract +
                '}';
    }
}

