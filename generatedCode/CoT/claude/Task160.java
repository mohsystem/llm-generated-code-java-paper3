package CoT.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Task160 {
    public static String makeHttpRequest(String urlStr) {
        StringBuilder response = new StringBuilder();
        try {
            // Validate and encode URL
            String encodedUrl = URLEncoder.encode(urlStr, StandardCharsets.UTF_8.toString())
                                       .replaceAll("%3A", ":")
                                       .replaceAll("%2F", "/");
            
            URL url = new URL(encodedUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // Set request method and timeouts
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            // Add security headers
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                String inputLine;
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            }
            conn.disconnect();
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return response.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUrls = {
            "https://www.example.com",
            "https://api.github.com",
            "https://jsonplaceholder.typicode.com/posts/1",
            "https://httpbin.org/get",
            "https://api.publicapis.org/entries"
        };
        
        for (String url : testUrls) {
            System.out.println("Testing URL: " + url);
            System.out.println("Response: " + makeHttpRequest(url));
            System.out.println("------------------------");
        }
    }
}
