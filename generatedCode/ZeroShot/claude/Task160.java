package ZeroShot.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Task160 {
    public static String makeHttpRequest(String urlString) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn;
            
            if (urlString.toLowerCase().startsWith("https")) {
                conn = (HttpsURLConnection) url.openConnection();
            } else {
                conn = (HttpURLConnection) url.openConnection();
            }
            
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            if (conn.getResponseCode() != 200) {
                return "Error: HTTP Response Code " + conn.getResponseCode();
            }

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            );
            
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            conn.disconnect();
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return response.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] urls = {
            "https://www.google.com",
            "https://api.github.com",
            "https://httpbin.org/get",
            "http://example.com",
            "https://invalid.domain.123"
        };
        
        for(String url : urls) {
            System.out.println("Testing URL: " + url);
            System.out.println(makeHttpRequest(url));
            System.out.println("------------------------");
        }
    }
}
