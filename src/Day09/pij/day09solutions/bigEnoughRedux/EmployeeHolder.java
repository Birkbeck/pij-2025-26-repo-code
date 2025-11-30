package pij.day09solutions.bigEnoughRedux;

import java.util.ArrayList;
import java.util.List;

/**
 * An EmployeeHolder can store an unbounded number of Employee references
 * and can be queried for these references via a zero-based index as well
 * as for the number of stored references (Ex 9).
 */
public class EmployeeHolder {
    // Stores the Employee references that have been added so far.
    private final List<Employee> employees;

    /** Constructs an empty EmployeeHolder. */
    public EmployeeHolder() {
        employees = new ArrayList<>();
    }

    public void add(Employee e) {
        employees.add(e);
    }

    public int size() {
        return employees.size();
    }

    public Employee get(int i) {
        return employees.get(i);
    }
}
