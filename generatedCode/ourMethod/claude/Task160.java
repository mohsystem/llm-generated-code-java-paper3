package ourMethod.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Task160 {
    public static String makeHttpRequest(String urlString) {
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        
        try {
            // Validate and encode URL
            String encodedUrl = URLEncoder.encode(URLDecoder.decode(urlString.trim(), StandardCharsets.UTF_8.toString()), 
                                                StandardCharsets.UTF_8.toString())
                                       .replaceAll("%3A", ":")
                                       .replaceAll("%2F", "/");
            
            URL url = new URL(encodedUrl);
            connection = (HttpURLConnection) url.openConnection();
            
            // Set safe connection properties
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setInstanceFollowRedirects(false);
            
            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }
            } else {
                return "Error: Server returned code " + responseCode;
            }
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (Exception e) {
                // Log the error but don't expose it
            }
        }
        
        return response.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUrls = {
            "https://www.example.com",
            "https://api.github.com",
            "https://httpbin.org/get",
            "https://postman-echo.com/get",
            "https://jsonplaceholder.typicode.com/posts/1"
        };

        for (String url : testUrls) {
            System.out.println("Testing URL: " + url);
            System.out.println("Response: " + makeHttpRequest(url));
            System.out.println("------------------------");
        }
    }
}
