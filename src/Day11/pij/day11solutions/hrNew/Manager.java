package pij.day11solutions.hrNew;

import java.util.Set;

/**
 * A Manager is an Employee who additionally manages a set of Employees.
 */
public class Manager extends Employee {
    private Set<Employee> managedEmployees;

    public Manager(String name, long salaryInPence, int id, Set<Employee> managedEmployees) {
        super(name, salaryInPence, id);
        // Set.copyOf conveniently throws a NullPointerException if its
        // parameter is or contains null; returns an unmodifiable Set otherwise
        this.managedEmployees = Set.copyOf(managedEmployees);
    }

    public Set<Employee> getManagedEmployees() {
        // the field is an unmodifiable Set, and its elements are immutable,
        // so it is safe to return
        return managedEmployees;
    }

    public void printManagedEmployees() {
        for (Employee e : managedEmployees) {
            System.out.println("    " + e);
        }
    }

    /* Methods equals(Object) and hashCode() can be inherited from class
       Employee: here we are using the id field for determining object
       equality, and we do not distinguish between an Employee and a
       Manager with the same id (it is up to the user of classes Manager
       and Employee to make sure that objects are created with a
       consistent meaning for the application; here: their id field).
     */
}
