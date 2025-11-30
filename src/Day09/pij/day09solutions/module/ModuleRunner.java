package pij.day09solutions.module;

import pij.day09.module.Student;

/**
 * Runner class for Module with different orders for Exercise 12.
 */
public class ModuleRunner {

    public static void runModule(Module module, Student[] students) {
        for (Student student : students) {
            module.enrol(student);
        }
        for (Student student : students) {
            module.attendClass(student);
        }
        System.out.println(module);
    }

    public static void main(String[] args) {
        Student s = new Student("Jane", "Doe", "1000");
        Student t = new Student("John", "Doe", "1001");
        Student u = new Student("Joe", "Bloggs", "1002");
        Student sCopy = new Student("Jane", "Doe", "1000");
        Student[] students = { u, t, s, sCopy };

        Module pijEnrolmentOrder = new Module("Programming in Java");
        Module pijNameOrder = new Module("Programming in Java",
                new NameThenStudentIDComparator());
        Module pijStudentIDOrder = new Module("Programming in Java",
                new StudentIDThenNameComparator());

        runModule(pijEnrolmentOrder, students);
        runModule(pijNameOrder, students);
        runModule(pijStudentIDOrder, students);
    }
}
