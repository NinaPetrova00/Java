public class Main {

    public static void main(String[] args) {

        // HashMap, TreeMap, EnumMap
        Employee filip = new Employee("Filip");
        Employee maria = new Employee("Maria");
        Employee pesho = new Employee("Pesho");
        Employee elena = new Employee("Elena");
        Employee ana = new Employee("Ana");

        Company microsoft = new Company("Microsoft");

        microsoft.hireEmployee(filip, Position.SOLUTIONS_ARCHITECT);
        microsoft.hireEmployee(elena, Position.JUNIOR_SOFTWARE_DEVELOPER);
        microsoft.hireEmployee(pesho, Position.QUALITY_ASSURANCE_ENGINEER);
        microsoft.hireEmployee(maria, Position.SENIOR_SOFTWARE_DEVELOPER);
        microsoft.hireEmployee(ana, Position.SENIOR_SOFTWARE_DEVELOPER);

        System.out.println("Display employees (using lambda)");
        microsoft.displayEmployeeListLambda();
        System.out.println("Display employees (using Map.Entry)");

        microsoft.displayEmployeeListEntry();

        microsoft.addMemberToTeam(filip, elena);
        microsoft.addMemberToTeam(filip, pesho);
        microsoft.addMemberToTeam(filip, maria);
        microsoft.displayTeams();

        microsoft.fireEmployee(elena);
        microsoft.displayTeams();

        microsoft.addMemberToTeam(ana, elena);
        microsoft.addMemberToTeam(ana, maria);
        microsoft.addMemberToTeam(ana, filip);

        microsoft.displayTeams();

        System.out.println(microsoft
                .numberOfEmployeesWithGreaterSalary(2000));

    }
}
