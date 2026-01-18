package pij.day11solutions.hrNew;

// Remove '//' before 'import' in the next line to use the old HumanResources.
//import pij.day11.hr.HumanResources;

import java.util.Set;

public class HumanResourcesRunner {

    public static void setUp(HumanResources hr) {
        hr.addEmployee("Alice", 1001, 2002);
        hr.addEmployee("Bob", 1002, 2002);
        hr.addManager("Celia", 1003, 2004, Set.of(1001, 1002));
        hr.addManager("Doris", 1004, 2004, Set.of(1003));
    }

    public static void main(String[] args) {
        HumanResources hr = new HumanResources("ACME");
        setUp(hr);
        hr.paySalaries();
        System.out.println();
        hr.printStaffList();
        System.out.println();
        hr.printManagerList();
    }
}
