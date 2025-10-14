package ourMethod.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class Task64 {
    private static final int MAX_RESPONSE_SIZE = 10 * 1024 * 1024; // 10MB
    private static final int CONNECTION_TIMEOUT = 10000; // 10 seconds
    private static final int READ_TIMEOUT = 10000; // 10 seconds

    public static JsonNode fetchAndParseJson(String urlString) throws Exception {
        if (urlString == null || urlString.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        // Validate URL format and scheme
        URI uri = new URI(urlString);
        String scheme = uri.getScheme();
        if (scheme == null || (!scheme.equalsIgnoreCase("https") && !scheme.equalsIgnoreCase("http"))) {
            throw new IllegalArgumentException("Only HTTP and HTTPS schemes are allowed");
        }

        URL url = uri.toURL();
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        
        try {
            connection = (HttpURLConnection) url.openConnection();
            
            // Enable hostname verification for HTTPS
            if (connection instanceof HttpsURLConnection) {
                HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;
                httpsConnection.setHostnameVerifier((hostname, session) -> {
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(hostname, session);
                });
            }
            
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(CONNECTION_TIMEOUT);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoInput(true);
            connection.setDoOutput(false);
            
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("HTTP error code: " + responseCode);
            }

            // Check content length
            long contentLength = connection.getContentLengthLong();
            if (contentLength > MAX_RESPONSE_SIZE) {
                throw new RuntimeException("Response size exceeds maximum allowed size");
            }

            reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)
            );

            StringBuilder responseBuilder = new StringBuilder();
            String line;
            int totalBytesRead = 0;
            
            while ((line = reader.readLine()) != null) {
                totalBytesRead += line.getBytes(StandardCharsets.UTF_8).length;
                if (totalBytesRead > MAX_RESPONSE_SIZE) {
                    throw new RuntimeException("Response size exceeds maximum allowed size");
                }
                responseBuilder.append(line);
            }

            String jsonString = responseBuilder.toString();
            
            if (jsonString.isEmpty()) {
                throw new RuntimeException("Empty response received");
            }

            // Parse JSON safely
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(jsonString);

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    // Log but don't throw
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static void main(String[] args) {
        // Test case 1: Valid JSON endpoint
        try {
            System.out.println("Test 1: Valid JSON URL");
            JsonNode result = fetchAndParseJson("https://jsonplaceholder.typicode.com/posts/1");
            System.out.println("Success: " + result.toString());
        } catch (Exception e) {
            System.err.println("Test 1 failed: " + e.getMessage());
        }

        // Test case 2: Null URL
        try {
            System.out.println("\\nTest 2: Null URL");
            fetchAndParseJson(null);
            System.out.println("Test should have failed");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // Test case 3: Empty URL
        try {
            System.out.println("\\nTest 3: Empty URL");
            fetchAndParseJson("");
            System.out.println("Test should have failed");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // Test case 4: Invalid scheme
        try {
            System.out.println("\\nTest 4: Invalid scheme");
            fetchAndParseJson("ftp://example.com/data.json");
            System.out.println("Test should have failed");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // Test case 5: Malformed URL
        try {
            System.out.println("\\nTest 5: Malformed URL");
            fetchAndParseJson("not a valid url");
            System.out.println("Test should have failed");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
