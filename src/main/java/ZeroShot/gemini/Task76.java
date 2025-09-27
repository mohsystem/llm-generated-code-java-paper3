package ZeroShot.gemini;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {

    public static String extractTitle(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder html = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                html.append(line);
            }
            reader.close();

            Pattern pattern = Pattern.compile("<title>(.*?)</title>");
            Matcher matcher = pattern.matcher(html.toString());
            if (matcher.find()) {
                return matcher.group(1).trim();
            } else {
                return "Title not found";
            }

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }


    public static void main(String[] args) {
        String[] testUrls = {
            "https://www.example.com",
            "https://www.google.com",
            "https://www.amazon.com",
            "https://www.wikipedia.org",
            "https://www.invalidurl.com" // Invalid URL for testing
        };

        for (String url : testUrls) {
            String title = extractTitle(url);
            System.out.println("URL: " + url + ", Title: " + title);
        }
    }
}