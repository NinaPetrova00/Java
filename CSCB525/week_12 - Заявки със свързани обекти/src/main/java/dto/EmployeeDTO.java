package dto;

// тук нямам анотация, защото не искам да създавам нова таблица employeeDTO в базата данни
public class EmployeeDTO {

    //това са двете полета, които ме интересуват - тях ги има и в Employee
    private long id;

    private String name;

    // конструктор с 2 параметъра
    public EmployeeDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // нямаме getters/setters

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
