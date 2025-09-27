package ourMethod.codestral;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task160 {
    public static void main(String[] args) {
        String[] testUrls = {"http://example.com", "https://www.google.com", "http://invalid-url.com", "https://secure-site.com"};
        for (String url : testUrls) {
            try {
                String response = sendHttpRequest(url);
                System.out.println("Response: " + response);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static String sendHttpRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP request failed with response code: " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}