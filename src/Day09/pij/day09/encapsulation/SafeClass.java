package pij.day09.encapsulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SafeClass is an example of a class with proper encapsulation, which does not
 * leak references that would allow programmers outside the class to modify the
 * object state without using a mutator method of SafeClass.
 */
public class SafeClass {
    private List<String> entries;
    private String name;

    /**
     * Constructs a new SafeClass object based on the constructor parameters.
     *
     * @param entries the entries to store; may be modified after the
     *                constructor call without affecting the new object
     * @param name the name of the new object
     */
    public SafeClass(List<String> entries, String name) {
        this.entries = new ArrayList<>(entries); // defensive copy
        this.name = name;  // String is immutable: references can be safely shared
    }

    /**
     * Adds an entry to this SafeClass object.
     *
     * @param s entry to be added
     */
    public void addEntry(String s) {
        entries.add(s); // harmless aliasing: class String is immutable
    }

    /**
     * Returns an unmodifiable view of the entries of this SafeClass object.
     *
     * @return an unmodifiable view of the entries of this SafeClass object.
     */
    public List<String> getEntries() {
        // The wrapper Collections.unmodifiableList() protects the (modifiable)
        // ArrayList used for the instance variable from mutator calls.
        return Collections.unmodifiableList(this.entries);
    }

    @Override
    public String toString() {
        return name + " " + entries; // returning a String is harmless
    }
}
