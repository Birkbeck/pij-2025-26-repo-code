package pij.day20.pizza.json;

import java.util.List;

/**
 * A class representing a response containing a list of available pizzas.
 * This class is used by Gson to serialize and deserialize the response.
 * It is immutable and provides a method to get a predefined list of available
 * pizzas.
 */
public final class AvailablePizzasResponse {

    private final List<String> availablePizzas;

    public AvailablePizzasResponse(List<String> availablePizzas) {
        this.availablePizzas = List.copyOf(availablePizzas);
    }

    public static AvailablePizzasResponse createDefaultAvailablePizzas() {
        return new AvailablePizzasResponse(List.of("Vegetarian", "Hawaiian",
                "Margherita", "BBQ Chicken", "Pepperoni"));
    }

    public List<String> availablePizzas() {
        return availablePizzas;
    }
}


// Alternatively, we can use a record -- records are more concise and suitable
// for this use case.
/*
public record AvailablePizzasResponse(List<String> availablePizzas) {

    public static AvailablePizzasResponse createDefaultAvailablePizzas() {
        return new AvailablePizzasResponse(List.of("Vegetarian", "Hawaiian", "Margherita", "BBQ Chicken", "Pepperoni"));
    }
}
*/


