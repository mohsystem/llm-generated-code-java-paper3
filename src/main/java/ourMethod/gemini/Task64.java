package ourMethod.gemini;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Task64 {

    public static JSONObject readJsonFromUrl(String urlString) throws IOException {
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL format: " + urlString);
        }

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code: " + responseCode);
        }


        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        JSONTokener tokener = new JSONTokener(response.toString());
        return new JSONObject(tokener);
    }


    public static void main(String[] args) {
        String[] testUrls = {
                "https://raw.githubusercontent.com/OAI/OpenAPI-Specification/main/examples/v3.0/petstore.json",
                "https://raw.githubusercontent.com/OAI/OpenAPI-Specification/main/examples/v2.0/petstore.json",
                "https://jsonplaceholder.typicode.com/todos/1",
                "https://www.google.com", // Invalid JSON URL Test case
                "invalid url" // Invalid URL format test case
        };

        for (String testUrl : testUrls) {
            try {
                System.out.println("Fetching JSON from: " + testUrl);
                JSONObject jsonObject = readJsonFromUrl(testUrl);
                System.out.println("JSON Object: " + jsonObject.toString(2)); // Pretty print JSON
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }
}