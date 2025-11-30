package pij.day13solutions.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Exercises 9 and 10.
 * Class Permutator provides static methods to allow for computing all
 * permutations both for a List&lt;E&gt; and for a String (which can
 * be seen as a character sequence).
 */
public class Permutator {

    /**
     * Returns a Set of all permutations of a given list. Allows for
     * repeated elements and null elements.
     *
     * @param input the list whose permutations we want; null elements
     *              are supported
     * @return a Set of all permutations of the input list
     * @param <E> element type for the input list and its permutations
     * @throws NullPointerException if input is null
     */
    public static <E> Set<List<E>> computeAllPermutations(List<E> input) {
        Set<List<E>> result = new LinkedHashSet<>();
        computeAllPermutations(input, result);
        return result;
    }

    /**
     * Computes all permutations of a given list and adds them to result.
     * Allows for repeated elements and null elements.
     *
     * @param input the list whose permutations we want; null elements
     *              are supported
     * @param result the set to which we want to add the permutations of input
     * @param <E> element type for the input list and its permutations
     * @throws NullPointerException if input or result is null
     */
    private static <E> void computeAllPermutations(List<E> input, Set<List<E>> result) {
        computeAllPermutationsWithPrefix(List.of(), input, result);
    }

    /**
     * Computes all permutations of a given input list, appends each
     * permutation to prefix, and adds the obtained list to result.
     * Allows for repeated elements and null elements.
     *
     * @param prefix the prefix to put before each permutation; null elements
     *               are supported
     * @param input the list whose permutations we want; null elements
     *              are supported
     * @param result the set to which we want to add the permutations of input
     *               appended to prefix
     * @param <E> element type for the input list and its permutations
     * @throws NullPointerException if prefix, input, or result is null
     */
    private static <E> void computeAllPermutationsWithPrefix(List<E> prefix,
                                                             List<E> input, Set<List<E>> result) {
        // if there is nothing left to add to the prefix, we are done
        if (input.isEmpty()) {
            result.add(prefix);
            return;
        }
        // otherwise pick an element of input, add it to prefix, and continue recursively
        for (int i = 0; i < input.size(); i++) {
            // input.get(i) moves from input to prefix
            List<E> recPrefix = new ArrayList<>(prefix);
            recPrefix.add(input.get(i));

            List<E> recInput = new ArrayList<>(input.subList(0, i));
            recInput.addAll(input.subList(i+1, input.size()));

            computeAllPermutationsWithPrefix(recPrefix, recInput, result);
        }
    }

    /**
     * Returns a Set of all permutations of a given String. Allows for
     * repeated elements.
     *
     * @param input the String whose permutations we want
     * @return a Set of all permutations of the input String
     * @throws NullPointerException if input is null
     */
    public static Set<String> computeAllStringPermutations(String input) {
        Set<String> result = new LinkedHashSet<>();
        computeAllStringPermutations(input, result);
        return result;
    }

    /**
     * Computes all permutations of a given String and adds them to result.
     *
     * @param input the String whose permutations we want
     * @param result the set to which we want to add the permutations of input
     * @throws NullPointerException if input or result is null
     */
    private static void computeAllStringPermutations(String input,
                                                     Set<String> result) {
        computeAllStringPermutationsWithPrefix("", input, result);
    }

    /**
     * Computes all permutations of a given String, appends them to prefix,
     * and adds the obtained String to result.
     *
     * @param prefix the prefix to put before each permutation
     * @param input the String whose permutations we want
     * @param result the set to which we want to add the permutations of input
     * @throws NullPointerException if prefix, input, or result is null
     */
    private static void computeAllStringPermutationsWithPrefix(String prefix,
                                                               String input,
                                                               Set<String> result) {
        // if there is nothing left to add to the prefix, we are done
        if (input.isEmpty()) {
            result.add(prefix);
            return;
        }
        // otherwise pick an element of input, add it to prefix, and continue recursively
        for (int i = 0; i < input.length(); i++) {
            // input.charAt(i) moves from input to prefix
            String recPrefix = prefix + input.charAt(i);
            String recInput = input.substring(0, i) + input.substring(i+1);
            computeAllStringPermutationsWithPrefix(recPrefix, recInput, result);
        }
    }
}
