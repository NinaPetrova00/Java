/**
 * Task 1 Week 3
 *
 * @author Kostadinova
 */
public class Employee implements Comparable<Employee> {

    private String name;

    public Employee() {
        this.name = "No Name";
    }

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + '}';
    }

    @Override
    public int compareTo(Employee employee) {
        return
                this.name.compareTo(employee.name);
    }

}
