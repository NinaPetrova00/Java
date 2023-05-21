import java.util.*;

/**
 * Task 1 Week 3
 *
 * @author Kostadinova
 */
public class Company {

    private String name;
    private static int numberOfContracts = 0;
    private Map<Employee, Integer> employeeList;
    private Map<Position, Double> salaryList;
    private Map<Employee, Position> employeeListPosition;
    private Map<Employee, Set<Employee>> teamsList;

    public Company(String name) {
        this.name = name;
        employeeList = new TreeMap();
        employeeListPosition = new TreeMap();
        salaryList = new EnumMap(Position.class);
        teamsList = new HashMap();
        setPositionSalaries();
    }

    public String getName() {
        return name;
    }

    // Task 1.1 Week 5
    public void setPositionSalary(Position position, double salary) {

        salaryList.put(position, salary);
    }

    // set salaries to all positions
    private void setPositionSalaries() {
        double startSalary = 1300;
        for (Position position : Position.values()) {
            setPositionSalary(position, startSalary += 500);
        }
    }

    // Task 1.2 Week 3
    public void hireEmployee(Employee employee, Position position) {
        employeeList.put(employee, ++numberOfContracts);
        employeeListPosition.put(employee, position);
    }

    // Task 1.3 Week 3
    public void fireEmployee(Employee employee) {
        employeeList.remove(employee);
        removeManagerFromTeam(employee);
        removeMemberFromTeams(employee);
        employeeListPosition.put(employee, null);
    }

    // Task 1.4 Week 3 Display employees (lambda)
    public void displayEmployeeListLambda() {
        employeeList.forEach(
                (employee, id) ->
                        System.out.println(employee + " => " + id));
    }

    //  Task 1.4 Week 3 Display employees (Map.Entry)
    public void displayEmployeeListEntry() {
        Set<Map.Entry<Employee, Integer>> set = employeeList.entrySet();
        for (Map.Entry<Employee, Integer> me : set) {
            System.out.print(me.getKey() + " => ");
            System.out.println(me.getValue());
        }
    }

    //  Task 1.5 Week 3
    public int numberOfEmployeesWithGreaterSalary(double salary) {
        int numberOfEmployees = 0;
        Collection<Position> positions = employeeListPosition.values();
        for (Position me : positions) {
            if (salaryList.containsKey(me) && salaryList.get(me) > salary) {
                numberOfEmployees++;
            }
        }
        return numberOfEmployees;
    }

    //  Task 1.6 Week 3
    public void addMangerToTeam(Employee manager) {
        if (employeeList.containsKey(manager)) {
            if (!teamsList.containsKey(manager)) {
                teamsList.put(manager, new TreeSet());
            }
        }
    }

    //  Task 1.7 Week 3
    public void addMemberToTeam(Employee manager, Employee employee) {
        if (!teamsList.containsKey(manager)) {
            addMangerToTeam(manager);
        }
        if (employeeList.containsKey(employee)) {
            teamsList.get(manager).add(employee);
        }
    }

    //  Task 1.8 Week 3
    public void removeManagerFromTeam(Employee employee) {

        teamsList.remove(employee);
    }

    //  Task 1.9 Week 3
    public void removeMemberFromTeams(Employee employee) {
        teamsList.forEach(
                (manager, team) -> team.remove(employee)
        );
    }

    // Task 1.10 Week 3 display teams with managers and members (lambda approach)
    public void displayTeams() {
        teamsList.forEach(
                (manager, team) -> {
                    System.out.println("Manager: ");
                    System.out.println(manager);
                    System.out.println("Team: ");
                    team.forEach(member -> System.out.println(member));
                }
        );
    }

    // Task 1.11 Week 3
    public double managersAverageSalary() {
        if (teamsList.size() > 0) {
            double sum = 0;
            Set<Employee> managers = teamsList.keySet();
            for (Employee manager : managers) {
                Position position = employeeListPosition.get(manager);
                sum += salaryList.get(position);
            }
            return sum / teamsList.size();
        }
        return 0;
    }
}
