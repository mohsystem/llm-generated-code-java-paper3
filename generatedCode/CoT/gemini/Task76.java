package CoT.gemini;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {

    public static String extractTitle(String httpsURL) {
        try {
            URL url = new URL(httpsURL);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            StringBuilder htmlContent = new StringBuilder();
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

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String[] testCases = {
                "https://www.google.com",
                "https://www.example.com",
                "https://www.wikipedia.org",
                "https://www.amazon.com",
                "https://www.stackoverflow.com"
        };

        for (String testCase : testCases) {
            System.out.println("URL: " + testCase);
            System.out.println("Title: " + extractTitle(testCase));
            System.out.println();
        }
    }
}