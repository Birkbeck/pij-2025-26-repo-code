package pij.day09.module;

import pij.day07.name.HasName;

import java.util.Objects;

/**
 * A Person has a given name and a family name.
 */
public class Person implements HasName {
    private final String givenName;
    private final String familyName;

    /**
     * Constructs a Person object with a given name and a family name.
     *
     * @param givenName the Person's given name
     * @param familyName the Person's family name
     */
    public Person(String givenName, String familyName) {
        this.givenName = givenName;
        this.familyName = familyName;
    }

    @Override
    public String getName() {
        return givenName + " " + familyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person person)) {
            return false;
        }
        // Object.equals(a, b) is graceful if a or b is null, whereas
        // a.equals(b) would throw a NullPointerException if a is null
        // (which is possible in our current class
        return Objects.equals(givenName, person.givenName) &&
                Objects.equals(familyName, person.familyName);
    }

    @Override
    public int hashCode() {
        // Objects.hash(...) computes a sensible hash function
        return Objects.hash(givenName, familyName);
    }

    @Override
    public String toString() {
        return getName();
    }
}
