package pij.day09solutions.module;

import pij.day09.module.Student;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A Module has a name and keeps track of enrolled students and their
 * attendance.
 */
public class Module {
    private final String moduleName;

    /**
     * Just count number of attendances rather than tracking specific dates
     * (to keep things simple for the example).
     */
    private final Map<Student, Integer> attendanceCounter;

    /**
     * Constructs a module with a specific name.
     *
     * @param moduleName the module name
     */
    public Module(String moduleName) {
        this.moduleName = moduleName;
        this.attendanceCounter = new LinkedHashMap<>();
    }

    /**
     * Constructs a module with a specific name and a comparator to use
     * for ordering Student objects.
     *
     * @param moduleName the module name
     */
    public Module(String moduleName, Comparator<Student> cmp) {
        // Ex 12: Downside of providing the Comparator<Student> in the
        // constructor only: what if, for the same module, we want to be
        // able to print the list in several different orders?
        // Better: (also) provide a method
        //    public String toString(Comparator<Student> cmp)
        this.moduleName = moduleName;
        this.attendanceCounter = new TreeMap<>(cmp);
    }

    /**
     * Enrols a Student on this Module. From that point on, their class
     * attendances will be counted. If the Student is already enrolled on
     * this Module, the method call has no effect.
     *
     * @param student Student to enrol on this Module
     */
    public void enrol(Student student) {
        if (attendanceCounter.containsKey(student)) {
            return; // student already enrolled, do not reset attendance count
        }
        attendanceCounter.put(student, 0);
    }

    /**
     * Increments the attendance count for the given Student, provided
     * that they are enrolled for this Module. Has no effect otherwise.
     *
     * @param student the Student whose attendance count should be incremented
     */
    public void attendClass(Student student) {
        // note: Integer rather than int, because the result may be null
        Integer numberOfAttendances = attendanceCounter.get(student);
        if (numberOfAttendances == null) {
            return; // student not enrolled
        }
        attendanceCounter.put(student, numberOfAttendances + 1);
    }

    @Override
    public String toString() {
        // class StringBuilder allows for efficient String construction
        StringBuilder sb = new StringBuilder();
        sb.append(moduleName).append("\n")
                .append("=".repeat(moduleName.length())).append("\n");
        for (Map.Entry<Student, Integer> entry : attendanceCounter.entrySet()) {
            sb.append(entry.getKey()).append(" : ").append(entry.getValue())
                    .append(" attendances\n");
        }
        return sb.toString();
    }
}
