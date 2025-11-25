package pij.day16.pipeline;

import java.util.Collection;
import java.util.List;

/**
 * Utility class with several static methods that allow us to perform
 * operations on collections of Person objects
 */
public class PersonUtils {

    /** Private constructor to ensure that the class cannot be instantiated. */
    private PersonUtils() {}

    /**
     * Returns the number of adults in the provided collection, with 18 as the
     * minimum age for adulthood.
     *
     * @param collection the collection of Person objects that we want to query
     * @return the number of adults in the provided collection, with 18 as the
     *  minimum age for adulthood
     * @throws NullPointerException if collection is null or contains null
     */
    public static long getAdultCount(Collection<? extends Person> collection) {
        final int MIN_ADULT_AGE = 18;
        return collection.stream()
                .filter(p -> p.getAge() >= MIN_ADULT_AGE)
                .count();
    }

    /**
     * Returns the names of the adults in the provided collection, with 18 as the
     * minimum age for adulthood.
     *
     * @param collection the collection of Person objects that we want to query
     * @return the names of the adults in the provided collection, with 18 as the
     *  minimum age for adulthood
     * @throws NullPointerException if collection is null or contains null
     */
    public static List<String> getAdultNames(Collection<? extends Person> collection) {
        final int MIN_ADULT_AGE = 18;
        return collection.stream()
                .filter(p -> p.getAge() >= MIN_ADULT_AGE)
                .map(Person::getName)
                .toList();
    }

    /**
     * Returns the names of the adults in the provided collection, with 18 as the
     * minimum age for adulthood. Duplicates are removed, and the list is sorted.
     *
     * @param collection the collection of Person objects that we want to query
     * @return the names of the adults in the provided collection, with 18 as the
     *  minimum age for adulthood; elements are distinct and in natural order
     * @throws NullPointerException if collection is null or contains null
     */
    public static List<String> getDistinctSortedAdultNames(Collection<? extends Person> collection) {
        final int MIN_ADULT_AGE = 18;
        return collection.stream()
                .filter(p -> p.getAge() >= MIN_ADULT_AGE)
                .map(Person::getName)
                .distinct()
                .sorted()
                .toList();
    }

    /**
     * Prints the names of the adults in the provided collection, with 18 as the
     * minimum age for adulthood.
     *
     * @param collection the collection of Person objects that we want to query
     * @throws NullPointerException if collection is null or contains null
     */
    public static void printAdultNames(Collection<? extends Person> collection) {
        final int MIN_ADULT_AGE = 18;
        collection.stream()
                .filter(p -> p.getAge() >= MIN_ADULT_AGE)
                .map(Person::getName)
                .forEach(System.out::println);
    }
}
