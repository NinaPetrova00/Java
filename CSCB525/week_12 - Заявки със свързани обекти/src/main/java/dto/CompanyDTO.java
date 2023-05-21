package dto;

import entity.Employee;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CompanyDTO {

    private long id;

    private String name;

    private String address;

    private BigDecimal initialCapital;

    private LocalDate foundationDate;

    public CompanyDTO() {
    }

    public CompanyDTO(long id, String name, String address, BigDecimal initialCapital, LocalDate foundationDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.initialCapital = initialCapital;
        this.foundationDate = foundationDate;
    }
}
