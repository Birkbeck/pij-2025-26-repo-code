package pij.day10solutions.primeDivisor;

import pij.day09solutions.mapToCount.MapToCount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Exercise 5.
 * PrimeDivisorList represents a positive integer number via a decomposition
 * into its prime divisors. Prime divisors can be added, queried, and removed.
 */
public class PrimeDivisorList {

    // Class PrimeDivisorList delegates to a List<Integer>
    // field internally. Extending a class that implements List<Integer>
    // (e.g., ArrayList<Integer>) would be possible and provide the whole
    // functionality of List<Integer> "for free", but would affect
    // flexibility, and we would need to take great care that, e.g., the
    // returned ListIterator<Integer> did not sneakily allow for setting
    // an entry to a non-prime number like 6.
    private List<Integer> list;

    /**
     * Initialises an empty list of prime divisors.
     */
    public PrimeDivisorList() {
        this.list = new ArrayList<>();
    }

    /**
     * Adds a given prime number to this list.
     *
     * @param p the prime number to add to this list
     * @throws NullPointerException if p is null
     * @throws IllegalArgumentException if p is a non-prime number
     */
    public void add(Integer p) {
        if (! isPrime(p)) { // throws NullPointerException if p is null
            throw new IllegalArgumentException(p + " is not a prime number!");
        }
        this.list.add(p);
    }

    /**
     * Removes and returns the list element at position index.
     *
     * @param index the position from which to remove an element
     * @return the prime number that was previously at position index
     * @throws IndexOutOfBoundsException if index < 0 or index >= size()
     */
    public Integer remove(int index) {
        return this.list.remove(index);
    }

    /**
     * Returns the list element at position index.
     *
     * @param index the position from which to retrieve an element
     * @return the list element at position index
     * @throws IndexOutOfBoundsException if index < 0 or index >= size()
     */
    public int get(int index) {
        return this.list.get(index);
    }

    /**
     * @return the number of elements in this list
     */
    public int size() {
        return this.list.size();
    }

    @Override
    public String toString() {
        if (this.list.isEmpty()) { // deal with special case first
            return "[ no factors, so the result is the neutral element of multiplication = 1 ]";
        }
        // Now we know: there is at least one prime factor. We do not really
        // care about the order of the factors, only about their multiplicity,
        // given in ascending order of the factors.
        SortedMap<Integer, Integer> factorsToExponents =
                collectionToOccurrenceCount(this.list);
        int product = getValue();

        // Now we have the ingredients to build the String.
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        boolean first = true;
        for (Map.Entry<Integer, Integer> factorToExponent : factorsToExponents.entrySet()) {
            final String SEPARATOR = " * ";
            final String EXP_SYMBOL = "^";

            // standard idiom to add a separator only /between/ elements
            if (first) {
                first = false;
            } else {
                sb.append(SEPARATOR);
            }

            sb.append(factorToExponent.getKey());
            int exp = factorToExponent.getValue();
            if (exp != 1) {
                sb.append(EXP_SYMBOL);
                sb.append(exp);
            }
        }
        sb.append(" = ");
        sb.append(product);
        sb.append(" ]");
        return sb.toString();
    }

    /**
     * @return the product of the entries of this prime divisor list
     *  (i.e., the positive int value represented by this list);
     *  1 if this list is empty
     */
    public int getValue() {
        int result = 1;
        for (int p : this.list) {
            result *= p;
        }
        return result;
    }

    /**
     * Returns whether the given number is a prime number.
     *
     * Borrowed from Day 3, Exercise 4, with small optimisation to leave the
     * loop early if possible. Unfortunately, we did not know packages back
     * then. If we do not put our classes into packages, we cannot import them!
     *
     * @param input an arbitrary number
     * @return whether input is a prime number
     */
    public static boolean isPrime(int input) {
        if (input < 2) {
            return false;
        }
        // idea: if input is not divisible by any of the integers
        // from 2 to input - 1, then it must be prime; try them all!
        for (int i = 2; i < input; i++) { // optimisation: !primeRefuted && i < input
            if (input % i == 0) { // i is a divisor of input, so input is not prime
                return false;
            }
        }
        return true;

        // The method can be optimised further with "domain knowledge" from
        // mathematics: it suffices to check numbers up to Math.sqrt(input) + 1
        // for being divisors of input -- the /smallest/ divisor of a number
        // among the values that we are checking is at most the square root,
        // so if we cannot find any of those, we can be sure that input is
        // really not prime. For the purpose of the exercise, the provided
        // implementation is sufficient, though.
    }

    /**
     * Returns a SortedMap<E, Integer> with the number of occurrences of each
     * element in natural order of E; map entries have at least 1 as value.
     *
     * @param coll the collection for which we want to know how often each of
     *             its elements occurs in it
     * @return a SortedMap<E, Integer> with the number of occurrences of each
     *  element in natural order of E; map entries have at least 1 as value
     * @param <E> the generic type of the collection elements
     * @throws NullPointerException if coll is null
     */
    public static <E extends Comparable<E>> SortedMap<E, Integer>
            collectionToOccurrenceCount(Collection<? extends E> coll) {
        Map<E, Integer> map = MapToCount.toMapToCount(coll); // DRY! :)
        return new TreeMap<>(map);
    }
}
