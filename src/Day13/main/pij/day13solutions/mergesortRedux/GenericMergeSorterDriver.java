package pij.day13solutions.mergesortRedux;

import java.util.List;

// Exercise 11.
public class GenericMergeSorterDriver {
    public static void main(String[] args) {
        List<String> words = List.of("c", "a", "e", "b", "d");
        List<String> mergeSorted = GenericMergeSorter.mergesort(words);
        System.out.println(mergeSorted);
    }
}
