package pij.day16.streamreuse;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        List<Student> students = StudentUtils.getStudents();

        System.out.println("--- Students aged 21 or older ---");
        // Print names of students aged 21 or older
        students.stream()
                .filter(student -> student.age() >= 21)
                .map(Student::name)
                .forEach(System.out::println);

        System.out.println("--- Student Stream Reuse Example ---");

        // The same code but storing the stream in a variable first
        Stream<Student> studentStream = students.stream();
        studentStream
                .filter(student -> student.age() >= 21)
                .map(Student::name)
                .forEach(System.out::println);

        System.out.println("--- Reusing Stream to count ages ---");
        // the below method attempts to count the collective age of the students
        // Attempting to reuse the same stream will cause an exception
        long count = studentStream
        // long count = students.stream()  // uncommenting this line and commenting the above line will work
                .map(Student::age)
                .count();

        System.out.println("--- Order by age: ");
        students.stream()
                //.sorted((s1, s2) -> Integer.compare(s1.age(), s2.age())) // lambda version
                .sorted(Comparator.comparingInt(Student::age)) // method reference version
                .forEach(s -> System.out.println(s.name() + ": " + s.age()));


        System.out.println("--- pairing students ---");
        // pairing all students with age above 20 with those below 20
        students.stream()
                .filter(s1 -> s1.age() > 20)
                .flatMap(s1 -> students.stream()
                        .filter(s2 -> s2.age() <= 20)
                        .map(s2 -> s1.name() + " - " + s2.name()))
                .forEach(System.out::println);

    }

}

/**
 * Utility class to provide student data.
 */
class StudentUtils{
    public static List<Student> getStudents(){
        return List.of(
            new Student("Alice", 20),
            new Student("Bob", 22),
            new Student("Charlie", 19),
            new Student("David", 23)
        );
    }
}

record Student(String name, int age) {}

/* The equivalent expanded version of the Student record:

final class Student {
    private final String name;
    private final int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Student) obj;
        return Objects.equals(this.name, that.name) &&
                this.age == that.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student[" +
                "name=" + name + ", " +
                "age=" + age + ']';
    }
}
*/
