package ourMethod.gpt4o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task160 {
    public static String makeHttpRequest(String urlString) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    public static void main(String[] args) {
        String[] testUrls = {
            "http://www.example.com",
            "https://www.google.com",
            "https://www.github.com",
            "https://www.stackoverflow.com",
            "https://www.wikipedia.org"
        };

        for (String url : testUrls) {
            System.out.println("Requesting: " + url);
            System.out.println("Response: " + makeHttpRequest(url));
        }
    }
}