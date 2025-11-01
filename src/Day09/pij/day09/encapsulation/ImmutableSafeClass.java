package pij.day09.encapsulation;

import java.util.List;

/**
 * ImmutableSafeClass is an example of a class whose objects are immutable.
 *<p>
 * The class is final so that there cannot be subclasses that might
 * introduce mutator methods.
 */
public final class ImmutableSafeClass {
    // final fields: will not be replaced by any method, present or future!
    private final List<String> entries;
    private final String name;

    /**
     * Constructs a new ImmutableSafeClass object.
     *
     * @param entries the entries to store; may be modified after the
     *                constructor call without affecting the new object
     * @param name the name of the new object
     */
    public ImmutableSafeClass(List<String> entries, String name) {
        this.entries = List.copyOf(entries); // immutable defensive copy
        this.name = name; // String is immutable: references can be safely shared
    }

    /**
     * Returns an unmodifiable view of the entries of this ImmutableSafeClass object.
     *
     * @return an unmodifiable view of the entries of this ImmutableSafeClass object
     */
    public List<String> getEntries() {
        // The result of List.copyOf() is unmodifiable by construction!
        return this.entries;
    }

    @Override
    public String toString() {
        return name + " " + entries; // returning a String is harmless
    }
}
