package pij.day20.pizza.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * A simple HTTP server that handles pizza orders and provides available pizzas.
 * This server listens on port 8008 by default and has the following endpoints:
 *<p>
 *<ul>
 * <li>GET /server-status: to get a status report for the server in HTML format</li>
 * <li>GET /available-pizzas: to retrieve available pizzas</li>
 * <li>POST /order: to submit a pizza order</li>
 *</ul>
 */
public class PizzaServer {

    private static final int PORT = 8008;
    private static final int NUMBER_OF_THREADS = 10;

    private final Counter orderCounter;

    public PizzaServer() {
        orderCounter = new Counter();
    }

    public void runServer() throws IOException {
        // Create an HTTP server that listens on port PORT.
        // Note this is a simple server using the com.sun.net.httpserver
        // package to demonstrate basic HTTP handling. This server is not
        // intended for production use, as it lacks many features of a
        // full-fledged web server. In particular, it does not handle
        // security, scalability, or advanced routing.
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        // Set the executor to handle requests concurrently, which allows
        // multiple requests to be processed simultaneously. This is useful
        // for a server that may receive multiple requests at the same time
        // and helps improve performance by using a thread pool. Prevents
        // blocking the server on a single request.
        server.setExecutor(Executors.newFixedThreadPool(NUMBER_OF_THREADS));

        // We now set up the different endpoints with their handlers.
        // Here we use a strategy pattern to use different classes
        // (OrderHandler, AvailablePizzasHandler, ServerStatusHandler) that all
        // implement the HttpHandler interface but each is attached to a
        // different endpoint.


        // Endpoint:
        // GET /server-status - get server status, including request count

        // The ServerStatusHandler handles GET requests and responds with HTML.
        // Note the "/" at the end of the path: it is needed so that the server
        // does not also respond to a request to /server-statusfoobar with the
        // given handler (see also the JavaDoc of method createContext(...)).
        server.createContext("/server-status/", new ServerStatusHandler(this));

        // Endpoint:
        // GET /available-pizzas - get information about available pizzas

        // The AvailablePizzasHandler handles GET requests to retrieve available pizzas
        // and responds with an object in JSON format corresponding to class
        // AvailablePizzasResponse in package pij.day20.pizza.json

        //// TODO
        ////server.createContext("/available-pizzas/", ...);


        // Endpoint:
        // POST /order - submit pizza order

        // The OrderHandler handles POST requests to submit a pizza order
        // and responds with a confirmation in JSON format.

        //// TODO
        //// server.createContext("/order/", ...);

        // Print to stdout instead of logging for simplicity
        System.out.println("Pizza server running at http://localhost:" + PORT + "/");
        server.start();
    }

    public void incrementOrderCount() {
        orderCounter.incrementCount();
    }

    public int getOrderCount() {
        return orderCounter.getCount();
    }

    public static void main(String[] args) throws IOException {
        PizzaServer pizzaServer = new PizzaServer();
        pizzaServer.runServer();
    }
}
