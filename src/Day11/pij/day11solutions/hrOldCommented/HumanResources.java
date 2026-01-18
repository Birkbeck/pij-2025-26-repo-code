package pij.day11solutions.hrOldCommented;

import java.util.*; // import of _all_ classes + interfaces of java.util, why?

/**
 * This is an example of *very* poorly designed code. Can you refactor it
 * (e.g., by introducing suitable classes, methods, ...) so that class
 * HumanResources still does the same job (its public interface and the
 * outward functionality are unchanged), but with a substantially better
 * design (you may and should improve the inner workings, and you may also
 * add methods to the public interface to make the class more usable)?
 */
public class HumanResources {

    private String companyName;

    // using several Lists whose index indicates what object on design level
    // we are referring to is not ideal since the programmers must make sure
    // that all lists are modified consistently; rather use a single list of
    // objects of a suitable class
    private List<String> employeeNames;
    private List<Integer> employeeIds;
    private List<Long> employeeSalariesInPence;

    // the ids seem to have quite a strong role as placeholders for employees,
    // we might use a dedicated class for employees (and one for managers)
    private Map<Integer, Set<Integer>> managerToManagedEmployees;

    // the JavaDoc documentation comments seem to be missing...

    public HumanResources(String companyName) {
        this.companyName = companyName;
        this.employeeNames = new ArrayList<>();
        this.employeeIds = new ArrayList<>();
        this.employeeSalariesInPence = new ArrayList<>();
        this.managerToManagedEmployees = new LinkedHashMap<>();
    }

    public void addEmployee(String name, int id, long salaryInPence) {
        this.employeeNames.add(name);
        this.employeeIds.add(id); // what if the id has already been assigned?
        this.employeeSalariesInPence.add(salaryInPence);
    }

    public void addManager(String name, int id, long salaryInPence, Set<Integer> managedEmployees) {
        this.employeeNames.add(name);
        this.employeeIds.add(id); // what if the id has already been assigned?
        this.employeeSalariesInPence.add(salaryInPence);

        // what if managedEmployees has a non-existent id?
        this.managerToManagedEmployees.put(id, managedEmployees);
    }

    public void paySalaries() {
        for (int i = 0; i < employeeNames.size(); i++) {
            System.out.println("Paying " + employeeNames.get(i) + ", id " +
                    employeeIds.get(i) + ": " + employeeSalariesInPence.get(i) + " pence...");
        }
    }

    public void printStaffList() {
        for (int i = 0; i < employeeNames.size(); i++) {
            System.out.println(employeeNames.get(i) + ", id " + employeeIds.get(i));
        }
    }

    public void printManagerList() {
        for (Map.Entry<Integer, Set<Integer>> entry :
                                        managerToManagedEmployees.entrySet()) {
            int id = entry.getKey();
            int index = employeeIds.indexOf(id);
            System.out.println("Manager " + employeeNames.get(index) + ", id "
                    + id + " manages:");
            for (int managedEmployeeId : entry.getValue()) {
                int managedEmployeeIndex = employeeIds.indexOf(managedEmployeeId);
                // there are a fair few repetitions of the way an employee is represented
                // on the screen
                System.out.println("    " + employeeNames.get(managedEmployeeIndex)
                        + ", id " + managedEmployeeId);
            }
        }
    }
}
