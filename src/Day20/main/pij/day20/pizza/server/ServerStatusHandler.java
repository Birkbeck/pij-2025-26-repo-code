package pij.day20.pizza.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Handles requests for the server status. Responds to GET requests with
 * a simple HTML page that shows the number of received orders.
 */
public class ServerStatusHandler implements HttpHandler {

    private static final String SUPPORTED_HTTP_METHOD = "GET";

    private final PizzaServer pizzaServer;

    /**
     * Initialises a ServerStatusHandler for a given pizza server that
     * counts how many orders it has received.
     *
     * @param pizzaServer the pizza server that counts the orders
     */
    public ServerStatusHandler(PizzaServer pizzaServer) {
        this.pizzaServer = Objects.requireNonNull(pizzaServer);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase(SUPPORTED_HTTP_METHOD)) {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_METHOD, -1);
            return;
        }

        String response = String.format("""
                    <html>
                        <body>
                            <h1>Pizza Service Status</h1>
                            <p>Number of orders: %s</p>
                        </body>
                    </html>
                    """.formatted(pizzaServer.getOrderCount()));

        exchange.getResponseHeaders().set("Content-Type", "text/html");
        byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, responseBytes.length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(responseBytes);
        }
    }
}
