package pij.day09.module;

/**
 * Runner class for Module.
 */
public class ModuleRunner {
    public static void main(String[] args) {
        Module pij = new Module("Programming in Java");
        Student s = new Student("Jane", "Doe", "1000");
        Student t = new Student("John", "Doe", "1001");
        Student u = new Student("Joe", "Bloggs", "1002");
        Student sCopy = new Student("Jane", "Doe", "1000");
        pij.enrol(s);
        pij.enrol(t);
        pij.enrol(u);
        pij.attendClass(s);
        pij.attendClass(t);
        pij.attendClass(sCopy);
        System.out.println(pij);
    }
}
