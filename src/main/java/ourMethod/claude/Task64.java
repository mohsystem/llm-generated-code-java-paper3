package ourMethod.claude;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Task64 {
    public static JSONObject fetchJsonFromUrl(String urlStr) throws IOException {
        // Input validation
        if (urlStr == null || urlStr.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }
        
        // Validate URL format
        URL url = new URL(urlStr);
        if (!url.getProtocol().equals("http") && !url.getProtocol().equals("https")) {
            throw new IllegalArgumentException("Only HTTP/HTTPS protocols are supported");
        }

        HttpURLConnection conn = null;
        BufferedReader reader = null;
        try {
            // Open connection with timeout
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestMethod("GET");

            // Check response code
            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code: " + responseCode);
            }

            // Read response
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Parse and return JSON
            return new JSONObject(response.toString());
            
        } finally {
            // Clean up resources
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUrls = {
            "https://api.github.com/users/octocat",
            "https://jsonplaceholder.typicode.com/posts/1", 
            "https://api.publicapis.org/entries",
            "https://api.openweathermap.org/data/2.5/weather?q=London&appid=test",
            "https://api.coindesk.com/v1/bpi/currentprice.json"
        };

        for (String url : testUrls) {
            try {
                System.out.println("\\nTesting URL: " + url);
                JSONObject json = fetchJsonFromUrl(url);
                System.out.println("Successfully fetched JSON: " + json.toString().substring(0, 100) + "...");
            } catch (Exception e) {
                System.err.println("Error fetching JSON from " + url + ": " + e.getMessage());
            }
        }
    }
}
