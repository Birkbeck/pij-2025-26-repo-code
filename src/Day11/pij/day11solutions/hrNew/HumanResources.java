package pij.day11solutions.hrNew;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Refactored version of pij.day11.hr.HumanResources. Now a dedicated class
 * Employee is used to represent the combination of a name, a salary, and
 * an id. Subclass Manager of Employee keeps track of managed Employees.
 *
 * (This kind of implementation details should not normally go into the
 * JavaDoc for the class!)
 */
public class HumanResources {

    // field is never reassigned in class HumanResources => can be final
    private final String companyName;

    // "class invariant":
    // all methods need to make sure that if they put an entry (i, e) in the
    // instance variable assignedIds, e.getId() == i holds;
    // methods must also make sure that they do not put in null as key or value;
    // methods may assume that these properties hold when they are called
    private final Map<Integer, Employee> assignedIds;

    // all methods need to make sure that elements of managers are also
    // in assignedIds as values (and they may assume that this is the case)
    private final Set<Manager> managers;

    /* The refactoring is not perfect: information such as an employee's id
       is represented in a redundant way (in assignedIds) to speed up id-based
       lookup. This makes the code harder to maintain correct.
     */

    /**
     * Initialises a new HumanResources object for a given company name.
     *
     * @param companyName the name of the company to which this HumanResources
     *                    object belongs
     * @throws NullPointerException if companyName is the null reference
     */
    public HumanResources(String companyName) {
        this.companyName = Objects.requireNonNull(companyName);
        this.assignedIds = new LinkedHashMap<>();
        this.managers = new LinkedHashSet<>();
    }

    /* Added the following helper method as a public method: it is useful also
       for users of the class (and does not reveal anything that should stay
       internal to the class).
     */

    /**
     * Returns whether id is in use in this HumanResources object.
     *
     * @param id the id to check
     * @return whether id is in use in this HumanResources object
     */
    public boolean isIdInUse(int id) {
        return assignedIds.containsKey(id);
    }

    /**
     * Adds an employee with given name, id, and salary to this HumanResources
     * object.
     *
     * @param name the employee's name; must not be null
     * @param id the employee's id; must not be currently in use by this
     *           HumanResources object
     * @param salaryInPence the employee's salary
     * @throws IllegalArgumentException if isIdInUse(id) returns true
     * @throws NullPointerException if employee is null
     */
    public void addEmployee(String name, int id, long salaryInPence) {
        Employee employee = new Employee(name, salaryInPence, id);
        addEmployee(employee);
    }

    /**
     * Private helper method for adding an Employee object with a given id.
     * (Works also for instances of subclasses of Employee, by Liskov's
     * substitution principle.)
     *
     * @param employee to be added; must not have been added before nor be null,
     *           must not be currently in use by this HumanResources object
     * @throws IllegalArgumentException if isIdInUse(employee.getId()) returns true
     * @throws NullPointerException if employee is null
     */
    private void addEmployee(Employee employee) {
        if (isIdInUse(employee.getId())) {
            throw new IllegalArgumentException("Id " + employee.getId()
                    + " is already in use!");
        }
        assignedIds.put(employee.getId(), employee);
    }

    /* Method

       public void addManager(String name, int id, long salaryInPence, Set<Integer> managedEmployees)

       is part of the public interface of the class. Since we are refactoring
       only _inside_ the class (which may well be used by external programmers),
       we must continue to offer the method. We might consider additionally
       overloading the method as

       public void addManager(Manager manager)

       (where manager would already have to know the employees that they are
       managing) or

       public void addManager(Manager manager, Set<Employee> managedEmployees)

       (where manager's managed employees would be set to managedEmployees by
       the method) to make the API more convenient to use.

       We _would_ be allowed to remove the method with its current signature if
       we did a larger-scale refactoring that modified also all classes that
       use the method. This can be done safely if we can be sure that we have
       control over all classes that use our class HumanResources, e.g., if we
       have never released class HumanResources outside our project and we are
       allowed to modify all classes in the project that use method addManager
       of class HumanResources.

       Things can be more complicated if the method is also present in an
       interface that class HumanResources implements because we would also
       have to modify the interface (and its users). However, this is not the
       case here.
     */

    /**
     * Adds a new manager with a given name, id, salary, and set of ids of
     * their managed employees.
     *
     * @param name the manager's name; must not be null
     * @param id the manager's id; must not be currently in use by this
     *           HumanResources object
     * @param salaryInPence the manager's salary
     * @param managedEmployees the ids of the employees that the added manager
     *                         manages; must all be known to this HumanResources
     *                         instance
     * @throws IllegalArgumentException if isIdInUse(id) returns true
     *  or if isIdInUse(i) returns false for some i in managedEmployees
     * @throws NullPointerException if name is null
     *  or if managedEmployees is or contains null
     */
    public void addManager(String name, int id, long salaryInPence, Set<Integer> managedEmployees) {
        // the next line throws a NullPointerException if managedEmployees
        // is null (because making an Iterator won't work) or contains null
        // (because unboxing an Integer null to an int won't work)
        for (int employeeId : managedEmployees) {
            if (! isIdInUse(employeeId)) {
                // also prevents creating a manager who would manage themselves
                throw new IllegalArgumentException("Managed employee id "
                        + employeeId + " is not know to HR!");
            }
        }

        // collect the 'reports' (i.e., the managed employees) for the
        // new Manager as Employee objects
        Set<Employee> reports = new LinkedHashSet<>();
        for (Integer managedId : managedEmployees) {
            Employee managedEmployee = assignedIds.get(managedId);
            reports.add(managedEmployee);
        }

        // actually create the new Manager
        Manager manager = new Manager(name, salaryInPence, id, reports);

        // method addEmployee takes care of making manager known to HR as an
        // employee (who receives a salary, is on the staff list, etc)
        addEmployee(manager);

        // make the new Manager known to HR in the capacity of a manager
        // (who is on the manager list)
        managers.add(manager);
    }

    /**
     * Pays their salaries to all employees known to this HumanResources
     * instance.
     */
    public void paySalaries() {
        for (Employee employee : assignedIds.values()) {
            System.out.println("Paying " + employee + ": "
                    + employee.getSalaryInPence() + " pence...");
        }
    }

    /**
     * Prints a list of all employees known to this HumanResources instance.
     */
    public void printStaffList() {
        for (Employee employee : assignedIds.values()) {
            System.out.println(employee);
        }
    }

    /**
     * Prints a list of all managers known to this HumanResources instance,
     * along with the managed employees of each manager.
     */
    public void printManagerList() {
        for (Manager m : managers) {
            System.out.println("Manager " + m + " manages:");
            m.printManagedEmployees();
        }
    }

    /* Added the following getter to give the originally ignored field
       companyName a purpose. Not really required for the refactoring.
     */

    /**
     * Returns the name of the company to which this HumanResources object
     * belongs.
     *
     * @return the name of the company to which this HumanResources object
     *  belongs
     */
    public String getCompanyName() {
        return companyName;
    }
}
