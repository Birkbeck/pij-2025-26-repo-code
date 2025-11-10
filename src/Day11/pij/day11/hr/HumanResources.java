package pij.day11.hr;

import java.util.*;

// This is an example of *very* poorly designed code.

public class HumanResources {

    private String companyName;
    private List<String> employeeNames;
    private List<Integer> employeeIds;
    private List<Long> employeeSalariesInPence;
    private Map<Integer, Set<Integer>> managerToManagedEmployees;

    public HumanResources(String companyName) {
        this.companyName = companyName;
        this.employeeNames = new ArrayList<>();
        this.employeeIds = new ArrayList<>();
        this.employeeSalariesInPence = new ArrayList<>();
        this.managerToManagedEmployees = new LinkedHashMap<>();
    }

    public void addEmployee(String name, int id, long salaryInPence) {
        this.employeeNames.add(name);
        this.employeeIds.add(id);
        this.employeeSalariesInPence.add(salaryInPence);
    }

    public void addManager(String name, int id, long salaryInPence, Set<Integer> managedEmployees) {
        this.employeeNames.add(name);
        this.employeeIds.add(id);
        this.employeeSalariesInPence.add(salaryInPence);
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
                System.out.println("    " + employeeNames.get(managedEmployeeIndex)
                        + ", id " + managedEmployeeId);
            }
        }
    }
}
