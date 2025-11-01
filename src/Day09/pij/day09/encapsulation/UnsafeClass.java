package pij.day09.encapsulation;

import java.util.List;

/** UnsafeClass is an "anti-example" with bad practice to avoid. */
public class UnsafeClass {
    private List<String> entries;
    private String name;

    /**
     * Constructs an UnsafeClass instance based on the constructor parameters.
     *
     * @param entries the initial entries for this UnsafeClass
     * @param name the name for this UnsafeClass
     */
    public UnsafeClass(List<String> entries, String name) {
        // Harmful aliasing! The caller of the constructor still has a reference
        // to the object referenced by instance variable this.entries and can
        // call its mutator methods to modify it behind our back. Bad!
        this.entries = entries;

        // Harmless aliasing: class String is immutable, so its objects can be
        // shared without problems.
        this.name = name;
    }

    /**
     * Adds an entry to this UnsafeClass.
     *
     * @param s entry to be added
     */
    public void addEntry(String s) {
        entries.add(s); // harmless aliasing: class String is immutable
    }

    /**
     * Returns the entries of this UnsafeClass.
     *
     * @return the entries of this UnsafeClass
     */
    public List<String> getEntries() {
        return entries; // harmful aliasing: List<String> has mutators
    }

    @Override
    public String toString() {
        return name + " " + entries; // returning a String is harmless
    }
}
