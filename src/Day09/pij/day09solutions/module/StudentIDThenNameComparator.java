package pij.day09solutions.module;

import pij.day09.module.Student;

import java.util.Comparator;

public class StudentIDThenNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        int studentIDDiff = o1.getStudentId().compareTo(o2.getStudentId());
        if (studentIDDiff != 0) {
            return studentIDDiff;
        }
        return o1.getName().compareTo(o2.getName());
    }

}
