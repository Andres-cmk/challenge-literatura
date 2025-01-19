package com.booksApi.andres_cmk.services.servicesAPI;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ApiConsumption {

    private static final String URL_BASE = "https://gutendex.com/books/";

    public String getDataByBook(String nameBook){
        try {
            String encodedNameBook = URLEncoder.encode(nameBook, StandardCharsets.UTF_8.toString());
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(URL_BASE+"?search="+encodedNameBook))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }catch (InterruptedException | IOException e) {System.out.println(e);}
        return "no se encontro el resultado";
    }
}
