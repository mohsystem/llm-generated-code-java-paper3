package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Arrays;

public class Task160 {
    public static String fetchURLContent(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        }
    }

    public static void main(String[] args) {
        List<String> testUrls = Arrays.asList(
            "http://example.com",
            "https://www.google.com",
            "http://www.invalid.url",
            "https://www.github.com",
            "https://www.wikipedia.org"
        );

        for (String testUrl : testUrls) {
            try {
                System.out.println("Content from URL (" + testUrl + "): " + fetchURLContent(testUrl));
            } catch (Exception e) {
                System.out.println("Failed to fetch content from " + testUrl + ": " + e.getMessage());
            }
        }
    }
}