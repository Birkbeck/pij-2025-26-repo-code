package pij.day16.pipeline;

import java.util.List;

public class SimplePersonDriver {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new SimplePerson("Alice", 20),
                new SimplePerson("Bob", 15),
                new SimplePerson("Carol", 42));
        long count = PersonUtils.getAdultCount(persons);
        List<String> adults = PersonUtils.getAdultNames(persons);
        System.out.println("There are " + count + " adults: " + adults);
        System.out.println("Printing them one per line:");
        PersonUtils.printAdultNames(persons);
    }
}
