package CoT.gemini;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task160 {
    public static String makeHttpRequest(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                conn.disconnect();
                return content.toString();
            } else {
                return "Request failed: HTTP error code " + responseCode;
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String[] testUrls = {
            "https://www.google.com",
            "https://www.example.com",
            "https://invalid-url",
            "http://localhost:8080",
            "https://api.github.com/users/octocat"
        };

        for (String url : testUrls) {
            String response = makeHttpRequest(url);
            System.out.println("URL: " + url);
            System.out.println("Response: " + response);
            System.out.println();
        }
    }
}