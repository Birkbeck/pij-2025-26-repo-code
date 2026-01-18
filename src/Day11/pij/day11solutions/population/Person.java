package pij.day11solutions.population;

import java.util.Objects;

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = Objects.requireNonNull(name, "name must not be null!");
    }

    public int getAge() {
        return age; // primitive values are safe to return
    }

    public String getName() {
        return name; // safe to return: class String is immutable
    }

    /* Mutators are possible, but as long as there is no explicit need,
       we do not introduce any here.

       Here we do not override equals (nor hashCode) because two different
       persons can have the same name and age. Thus, we use object identity
       for method equals, as inherited from Object.
     */
}
