package pij.day11solutions.population;

import java.util.Objects;
import java.util.Set;

public class City implements HasPopulation {

    // We don't want duplicates here, so use a Set.
    private Set<Person> persons;

    public City(Set<Person> persons) {
        this.persons = Set.copyOf(Objects.requireNonNull(persons,
                "Constructor parameter must not be null!"));
        if (persons.contains(null)) {
            throw new NullPointerException("Constructor parameter must not contain null!");
        }
    }

    @Override
    public int getPopulation() {
        return persons.size();
    }

    /* We _could_ provide getters or setters for persons (it is safe to
       return), or methods to query whether a Person is in the City or
       to add a Person to the City... however, none of these are required
       by the provided class diagram, so we don't.
     */
}
