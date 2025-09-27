package ourMethod.gemini;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Task160 {

    public static String makeHttpRequest(String urlString) throws IOException {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                return "HTTP request failed with response code: " + responseCode;
            }

        } catch (IOException e) {
            throw new IOException("Error making HTTP request: " + e.getMessage());

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] testUrls = {
            "https://www.example.com",
            "https://www.google.com",
            "https://www.amazon.com",
            "https://www.wikipedia.org",
            "http://example.org" // Testing a different protocol
        };

        for (String testUrl : testUrls) {
            try {
                String response = makeHttpRequest(testUrl);
                System.out.println("Response from " + testUrl + ":\n" + response.substring(0, Math.min(response.length(), 200)) + "...\n"); // Limiting output for brevity

            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        scanner.close();

    }
}