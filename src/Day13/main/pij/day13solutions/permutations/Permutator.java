package pij.day13solutions.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Permutator {

    public static <E> Set<List<E>> computeAllPermutations(List<E> input) {
        Set<List<E>> result = new LinkedHashSet<>();
        computeAllPermutations(input, result);
        return result;
    }

    private static <E> void computeAllPermutations(List<E> input, Set<List<E>> result) {
        computeAllPermutationsWithPrefix(List.of(), input, result);
    }

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


    public static Set<String> computeAllStringPermutations(String input) {
        Set<String> result = new LinkedHashSet<>();
        computeAllStringPermutations(input, result);
        return result;
    }

    private static void computeAllStringPermutations(String input, Set<String> result) {
        computeAllStringPermutationsWithPrefix("", input, result);
    }

    private static void computeAllStringPermutationsWithPrefix(String prefix,
                                                             String input, Set<String> result) {
        // if there is nothing left to add to the prefix, we are done
        if (input.isEmpty()) {
            result.add(prefix);
            return;
        }
        // otherwise pick an element of input, add it to prefix, and continue recursively
        for (int i = 0; i < input.length(); i++) {
            // input.get(i) moves from input to prefix
            String recPrefix = prefix + input.charAt(i);

            String recInput = input.substring(0, i) + input.substring(i+1);

            computeAllStringPermutationsWithPrefix(recPrefix, recInput, result);
        }
    }
}
