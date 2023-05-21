package entity;

import javax.persistence.*;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "useCommonParts")
    private boolean useCommonParts;

    @ManyToOne(fetch = FetchType.LAZY) // един апартамент, много животни
    @JoinColumn(name = "apartmentID", nullable = false)
    private Apartment apartment;

    public Pet() {
    }

    public Pet(long id, boolean useCommonParts, Apartment apartment) {
        this.id = id;
        this.useCommonParts = useCommonParts;
        this.apartment = apartment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isUseCommonParts() {
        return useCommonParts;
    }

    public void setUseCommonParts(boolean useCommonParts) {
        this.useCommonParts = useCommonParts;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", useCommonParts=" + useCommonParts +
                '}';
    }
}
