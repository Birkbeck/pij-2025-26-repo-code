package pij.day09.module;

import java.util.Objects;

/** A Student is a Person who additionally has a student ID. */
public class Student extends Person {
    private final String studentId;

    /**
     * Constructs a Student object with a given name, a family name, and
     * an id number.
     *
     * @param givenName the Student's given name
     * @param familyName the Student's family name
     * @param studentId the Student's id number
     */
    public Student(String givenName, String familyName, String studentId) {
        super(givenName, familyName);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student student)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId);
    }

    @Override
    public String toString() {
        return super.toString() + ", student ID " + studentId;
    }
}
