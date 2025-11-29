package pij.day06solutions.employee;

// The public interface of the class is in the following multi-line comment.
// We remove all the non-public fields, methods, and constructors, the
// implementations of the public methods and constructors, and the names of
// the parameters of the public methods and constructors. What remains is
// the public interface of class Employee.

/*
public class Employee {



    public Employee(int   , String     )




    public long getId()



    public String getName()



    public void setName(String     )



    public long getSalaryInPence()




    private long calculateSalary()



}
*/

public class Employee {
    private long id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalaryInPence() {
        long l = calculateSalary();
        return l;
    }

    private long calculateSalary() {
        // slightly unusual approach to implementing this functionality
        return name.length() + id;
    }
}
