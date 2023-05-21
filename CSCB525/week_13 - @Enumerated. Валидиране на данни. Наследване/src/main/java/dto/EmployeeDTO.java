package dto;

public class EmployeeDTO {

    private long id;

    private String name;

    public EmployeeDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
