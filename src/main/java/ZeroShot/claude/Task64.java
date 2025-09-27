package ZeroShot.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Task64 {
    public static JSONObject fetchJsonFromUrl(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code: " + conn.getResponseCode());
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            return new JSONObject(response.toString());
            
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUrls = {
            "https://jsonplaceholder.typicode.com/posts/1",
            "https://api.github.com/users/github",
            "https://api.publicapis.org/entries",
            "https://jsonplaceholder.typicode.com/todos/1",
            "https://api.publicapis.org/random"
        };

        for (String url : testUrls) {
            try {
                JSONObject result = fetchJsonFromUrl(url);
                System.out.println("Successfully fetched JSON from: " + url);
                System.out.println(result.toString(2));
            } catch (Exception e) {
                System.err.println("Error fetching JSON from " + url + ": " + e.getMessage());
            }
            System.out.println("------------------------");
        }
    }
}
