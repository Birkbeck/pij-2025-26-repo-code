import java.util.Arrays;

/**
 * An EmployeeHolder can store an unbounded number of Employee references
 * and can be queried for these references via a zero-based index as well
 * as for the number of stored references.
 */
public class EmployeeHolder {
    // Stores the Employee references that have been added so far.
    // Only the first nextFreeIndex - 1 positions have valid content.
    private Employee[] employees;

    // Indicates the index where the next Employee will be added.
    // If it is equal to employees.length, we must make employees
    // point to a larger array that has the same content as the
    // current employees array at its initial indices before we
    // add another entry to employees.
    private int nextFreeIndex;

    /** Constructs an empty EmployeeHolder. */
    public EmployeeHolder() {
        final int INITIAL_CAPACITY = 1; // very small so we can test the resizing easily
        employees = new Employee[INITIAL_CAPACITY];
    }

    public void add(Employee e) {
        ensureBigEnoughForExtraElement();
        employees[nextFreeIndex] = e;
        nextFreeIndex++;
    }

    public int size() {
        return nextFreeIndex;
    }

    public Employee get(int i) {
        // the result may not be valid if i >= size(), and an
        // ArrayIndexOutOfBoundsException may be thrown if i < 0 or
        // i >= employees.length
        return employees[i];
    }

    // helper method to take care that this EmployeeHolder object has
    // enough space for another Employee reference
    private void ensureBigEnoughForExtraElement() {
        final int GROWTH_FACTOR = 2; // needs to be at least 2 for the resizing to work
        if (nextFreeIndex == employees.length) {
            // OPTION 1:
            Employee[] moreEmployees = new Employee[GROWTH_FACTOR * employees.length];
            for (int i = 0; i < employees.length; i++) {
                moreEmployees[i] = employees[i];
            }

            // OPTION 2:
            /*
            Employee[] moreEmployees =
                    Arrays.copyOf(employees, GROWTH_FACTOR * employees.length);
            */

            // replace too-small array in the field (aka instance variable)
            // by larger copy
            employees = moreEmployees;
        }
    }
}
