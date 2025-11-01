package pij.day09.intRememberer;

import java.util.HashSet;
import java.util.Set;

/** An IntRememberer remembers int values that are passed to it. */
public class IntRememberer {
    private final Set<Integer> knownInts;

    /** Constructs an IntRememberer that knows no int values yet. */
    public IntRememberer() {
        knownInts = new HashSet<>();
    }

    /**
     * Make the given int known to this IntRememberer.
     *
     * @param number the int to remember
     */
    public void makeKnown(int number) {
        knownInts.add(number);
    }

    /**
     * Returns whether this IntRememberer knows the provided int.
     *
     * @param number the int to be checked
     * @return whether this IntRememberer knows the provided int
     */
    public boolean knows(int number) {
        return knownInts.contains(number);
    }

    /**
     * Returns the number of int values that this IntRememberer knows.
     *
     * @return the number of int values that this IntRememberer knows
     */
    public int size() {
        return knownInts.size();
    }

    @Override
    public String toString() {
        return knownInts.toString();
    }
}
