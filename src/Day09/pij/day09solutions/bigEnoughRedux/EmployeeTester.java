package pij.day09solutions.bigEnoughRedux;

// Exercise 9
public class EmployeeTester {
    public static void main(String[] args) {
        Employee alice = new Employee("Alice", 1000);
        Employee bob = new Employee("Bob", 1001);
        Employee charlotte = new Employee("Charlotte", 1002);
        Employee derek = new Employee("Derek", 1003);
        Employee sam = new Employee("Sam", 1010);
        Employee serena = new Employee("Serena", 1011);

        EmployeeHolder company = new EmployeeHolder();
        System.out.println("Initial company size: " + company.size());
        company.add(alice);
        company.add(bob);
        company.add(charlotte);
        company.add(derek);
        company.add(sam);
        company.add(serena);

        System.out.println("Company size after adding 4 employees: " +
                company.size());
        for (int i = 0; i < company.size(); i++) {
            Employee e = company.get(i);
            System.out.println("Employee " + i + " is " + e.getName() +
                    " with ID number " + e.getIdNumber());
        }

        System.out.println("Employees with even ID number:");
        for (int i = 0; i < company.size(); i++) {
            Employee e = company.get(i);
            if (e.getIdNumber() % 2 == 0) {
                System.out.println(e.getName() + " with ID number " +
                        e.getIdNumber());
            }
        }

        System.out.println("Employees whose name starts with 'S':");
        for (int i = 0; i < company.size(); i++) {
            Employee e = company.get(i);
            if (e.getName().startsWith("S")) {
                System.out.println(e.getName() + " with ID number " +
                        e.getIdNumber());
            }
        }
    }
}
