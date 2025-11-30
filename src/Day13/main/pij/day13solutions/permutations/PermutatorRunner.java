package pij.day13solutions.permutations;

import java.util.List;
import java.util.Set;

public class PermutatorRunner {

    public static void runList() {
        List<Integer> list = List.of(0,1,2,3,4,5,6,7,8,9);
        long nanos1 = System.nanoTime();
        Set<List<Integer>> permutations = Permutator.computeAllPermutations(list);
        long nanos2 = System.nanoTime();
        System.out.println("Computation took " + (nanos2-nanos1)/1000000 + " ms.");
        System.out.println("Result size: " + permutations.size());
        //System.out.println("Result: " + permutations);
    }

    public static void runString() {
        String input = "abcdefghi";
        long nanos1 = System.nanoTime();
        Set<String> permutations = Permutator.computeAllStringPermutations(input);
        long nanos2 = System.nanoTime();
        System.out.println("Computation took " + (nanos2-nanos1)/1000000 + " ms.");
        System.out.println("Result size: " + permutations.size());
        //System.out.println("Result: " + permutations);
    }

    public static void main(String[] args) {
        runList();
        runString();
    }
}
