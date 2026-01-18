package pij.day11solutions.hrNew;

import java.util.Objects;

/**
 * Immutable class to represent the concept of an Employee with a name,
 * a salary, and an id. Equality is determined via the id. Authors of
 * subclasses must ensure that their subclasses are immutable as well.
 */
public class Employee {
    private String name;
    private long salaryInPence;
    private int id;

    public Employee(String name, long salaryInPence, int id) {
        this.name = Objects.requireNonNull(name);
        this.salaryInPence = salaryInPence; // also negative salaries are allowed
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getSalaryInPence() {
        return salaryInPence;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + ", id " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee employee)) {
            return false;
        }
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
