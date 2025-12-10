package pij.day20.pizza.client;
import com.google.gson.Gson;
import pij.day20.pizza.json.AvailablePizzasResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


/**
 * PizzaClient is a simple HTTP client for sending pizza orders and retrieving available pizzas.
 * It uses Java's HttpClient to communicate with a pizza server.
 * the Send Order method sends a pizza order in JSON format
 * the Get Available Pizzas method retrieves a list of available pizzas from the server and use Gson to parse the JSON response.
 * We are separating the client logic from the GUI logic.
 */
public class PizzaClient {

    private static final Duration CONNECT_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(10);
    private static final String PROTOCOL = "http";
    private static final String SERVER = "localhost";
    private static final int PORT = 8008;

    private static final String RESOURCE_ORDER = "/order/";
    private static final String RESOURCE_AVAILABLE_PIZZAS = "/available-pizzas/";

    private final HttpClient httpClient;

    public PizzaClient() {
        httpClient = HttpClient.newBuilder()
                .connectTimeout(CONNECT_TIMEOUT)
                .build();
    }

    public String sendOrder(String customer, String pizza, String size) throws IOException {

        // Pizza order JSON, we could use a library like Gson to create this
        // JSON String, but here we are using String formatting for simplicity
        String orderJson = """
            {
                "customer": "%s",
                "pizza": "%s",
                "size": "%s"
            }
            """.formatted(customer, pizza, size);

        // Send JSON
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(makeProtocolServerPortPrefix() +
                        RESOURCE_ORDER))
                .timeout(REQUEST_TIMEOUT)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(orderJson, StandardCharsets.UTF_8))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            return response.body();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Request interrupted", e);
        }
    }

    /**
     * Retrieves a list of available pizzas from the server.
     * This method sends a GET request to the server and expects a JSON response containing a list
     * of available pizzas. It uses Gson to parse the JSON response into a list of strings
     * representing the available pizzas.
     * @return a list of available pizzas
     * @throws IOException if there is an error during the HTTP request or response handling
     */
    public List<String> getAvailablePizzas() throws IOException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(makeProtocolServerPortPrefix() +
                        RESOURCE_AVAILABLE_PIZZAS))
                .timeout(REQUEST_TIMEOUT)
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            // Uncomment the next line to see the response body in the console
            //System.out.println("response: \n" +response.body());
            // We are using Gson to parse the JSON response, which is a common practice in Java applications
            // Gson is a library that converts Java objects to JSON and vice versa, this is why we create a class AvailablePizzasResponse
            // to represent the JSON response structure.
            AvailablePizzasResponse resp = new Gson().fromJson(response.body(), AvailablePizzasResponse.class);
            return resp.availablePizzas();

        } catch (InterruptedException e) {
            // If the request is interrupted, we should handle it gracefully
            // we return an empty list and print an error message to the console
            Thread.currentThread().interrupt();
            System.err.println("Request interrupted: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private static String makeProtocolServerPortPrefix() {
        return PROTOCOL + "://" + SERVER + ":" + PORT;
    }
}
