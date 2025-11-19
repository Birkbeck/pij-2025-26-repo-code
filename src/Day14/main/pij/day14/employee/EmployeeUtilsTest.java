package pij.day14.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for EmployeeUtils
 */
class EmployeeUtilsTest {


    @Test
    void testSingleEmployeeGetEmployeeTreeStructure(){
        Employee single = new Employee("Adam");
        var expected = """
                Adam""";
        assertEquals(expected, EmployeeUtils.getEmployeeTreeStructure(single));
    }

    @Test
    void testEmployeeWith1LineManagerGetEmployeeTreeStructure(){
        Employee lineManager = new Employee("Bob");
        Employee single = new Employee("Adam", lineManager);
        var expected = """
                Bob
                |
                Adam""";
        assertEquals(expected, EmployeeUtils.getEmployeeTreeStructure(single));
    }


    @Test
    void testEmployeeWith2LineManagerGetEmployeeTreeStructure(){
        Employee planManager = new Employee("Cat");
        Employee lineManager = new Employee("Bob", planManager);
        Employee single = new Employee("Adam", lineManager);
        var expected = """
                Cat
                |
                Bob
                |
                Adam""";
        assertEquals(expected, EmployeeUtils.getEmployeeTreeStructure(single));
    }

    @Test
    void testEmployeeWith3LineManagerGetEmployeeTreeStructure(){
        Employee ceo = new Employee("Deepika");
        Employee planManager = new Employee("Cat", ceo);
        Employee lineManager = new Employee("Bob", planManager);
        Employee single = new Employee("Adam", lineManager);
        var expected = """
                Deepika
                |
                Cat
                |
                Bob
                |
                Adam""";
        assertEquals(expected, EmployeeUtils.getEmployeeTreeStructure(single));
    }

}
