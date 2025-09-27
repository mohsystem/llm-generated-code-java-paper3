package Vanilla.gemini;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {

    public static String extractTitle(String httpsUrl) throws Exception {
        URL url = new URL(httpsUrl);
        URLConnection connection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder htmlContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            htmlContent.append(line);
        }
        reader.close();

        Pattern titlePattern = Pattern.compile("<title>(.*?)</title>");
        Matcher matcher = titlePattern.matcher(htmlContent.toString());
        if (matcher.find()) {
            return matcher.group(1).trim();
        } else {
            return "Title not found";
        }
    }

    public static void main(String[] args) throws Exception {
        String url1 = "https://www.example.com";
        String url2 = "https://www.google.com";
        String url3 = "https://www.amazon.com";
        String url4 = "https://www.wikipedia.org";
        String url5 = "https://www.youtube.com";

        System.out.println("Title for " + url1 + ": " + extractTitle(url1));
        System.out.println("Title for " + url2 + ": " + extractTitle(url2));
        System.out.println("Title for " + url3 + ": " + extractTitle(url3));
        System.out.println("Title for " + url4 + ": " + extractTitle(url4));
        System.out.println("Title for " + url5 + ": " + extractTitle(url5));
    }
}