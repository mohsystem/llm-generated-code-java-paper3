package Vanilla.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task160 {
    public static String makeHttpRequest(String urlString) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            return response.toString();
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] urls = {
            "https://www.google.com",
            "https://www.github.com",
            "https://www.example.com",
            "https://api.github.com",
            "https://httpbin.org/get"
        };
        
        for(String url : urls) {
            System.out.println("Testing URL: " + url);
            System.out.println(makeHttpRequest(url));
            System.out.println("------------------------");
        }
    }
}
