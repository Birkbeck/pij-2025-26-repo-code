package pij.day11solutions.population;

import java.util.Objects;
import java.util.Set;

public class Country implements HasPopulation {

    // We don't want duplicates here, so use a Set.
    private Set<City> cities;

    public Country(Set<City> cities) {
        this.cities = Set.copyOf(Objects.requireNonNull(cities,
                "Constructor parameter must not be null!"));
        if (cities.contains(null)) {
            throw new NullPointerException("Constructor parameter must not contain null!");
        }
    }


    @Override
    public int getPopulation() {
        int result = 0;
        for (City city : cities) {
            result += city.getPopulation();
        }
        return result;
    }
}
