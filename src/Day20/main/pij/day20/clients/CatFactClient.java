package pij.day20.clients;

import com.google.gson.Gson;
import pij.day20.catFact.CatFact;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * Client for the REST API offered at
 * <a href="https://catfact.ninja/fact">https://catfact.ninja/fact</a>
 * to issue a GET request and to print the received fact about cats.
 */
public class CatFactClient {

    public static void main(String[] args)
            throws URISyntaxException, IOException, InterruptedException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                //.uri(new URI("https://catfact.ninja/fact/"))
                .uri(new URI("http://localhost:8001/fact/"))
                .GET()
                .build();
        HttpResponse<String> response;
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            response = httpClient.send(getRequest, BodyHandlers.ofString());
        }
        System.out.println(response.body());

        // parse the response body into an object
        Gson gson = new Gson();
        CatFact catFact = gson.fromJson(response.body(), CatFact.class);

        System.out.println(catFact);
    }
}