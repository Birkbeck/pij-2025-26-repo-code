package pij.day09solutions.setOrder;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// Exercise 1
public class SetOrder {

    public static void fillAndPrintSet(Set<String> set) {
        List<String> languages = List.of("Java", "C", "PHP", "JavaScript",
                "Python", "Rust", "Haskell", "Go", "Prolog");
        set.addAll(languages);
        System.out.println(set);
    }

    public static void main(String[] args) {

        // printout in no clearly recognisable order for HashSet<String>
        // (the API docs do not make any guarantees, so this is okay)
        fillAndPrintSet(new HashSet<>());

        // printout in insertion order for LinkedHashSet<String>
        fillAndPrintSet(new LinkedHashSet<>());

        // printout in natural order for TreeSet<String>
        // (natural order: given by the compareTo(String) method
        // as class String implements Comparable<String>)
        fillAndPrintSet(new TreeSet<>());
    }
}
