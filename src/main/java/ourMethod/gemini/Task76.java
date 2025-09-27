package ourMethod.gemini;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {

    public static String extractPageTitle(String httpsURL) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(httpsURL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String htmlContent = response.body();


            Pattern titlePattern = Pattern.compile("<title>(.*?)</title>", Pattern.CASE_INSENSITIVE);
            Matcher matcher = titlePattern.matcher(htmlContent);
            if (matcher.find()) {
                return matcher.group(1).trim();
            } else {
                return "Title not found";
            }

        } catch (Exception e) {
            return "Error retrieving page title: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String[] testURLs = {
                "https://www.example.com",
                "https://www.google.com",
                "https://www.wikipedia.org",
                "https://www.amazon.com",
                "https://www.invalidurl.com" 
        };

        for (String url : testURLs) {
            System.out.println("URL: " + url);
            String title = extractPageTitle(url);
            System.out.println("Title: " + title);
            System.out.println("----");
        }


        if (args.length > 0) {
           for (String arg: args) {
                System.out.println("Title from Args: " + extractPageTitle(arg));
           }
        }
    }
}