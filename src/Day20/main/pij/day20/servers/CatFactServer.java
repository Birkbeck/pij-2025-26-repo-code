package pij.day20.servers;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;

/**
 * Minimal HTTP server to serve requests for cat facts. This class
 * illustrates the concepts, but it is not meant for production use!
 */
public class CatFactServer {
    private static final int PORT = 8001; // at least 1024, at most 49151
    private static final int BACKLOG = 0; // socket backlog, 0 uses default
    private static final String PATH = "/fact/"; // the path to the resource

    private static final String CAT_FACT = "Cats are not dogs.";
    private static final String RESPONSE_BODY = "{\"fact\":\"" + CAT_FACT +
            "\",\"length\":" + CAT_FACT.length() + "}";

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT),
                BACKLOG);
        HttpHandler handler = exchange -> {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,
                    RESPONSE_BODY.length());
            try (OutputStream outputStream = exchange.getResponseBody()) {
                outputStream.write(RESPONSE_BODY.getBytes());
            }
        };
        httpServer.createContext(PATH, handler);
        httpServer.start();
    }
}
