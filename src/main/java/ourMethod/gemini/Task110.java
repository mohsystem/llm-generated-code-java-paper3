package ourMethod.gemini;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task110 {

    public static boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }



    public static void main(String[] args) {
        String[] testCases = {
                "https://www.example.com",
                "http://example.com",
                "ftp://ftp.example.com",
                "invalid-url",
                "https://www.example.com/path?query=string#fragment"
        };

        for (String testCase : testCases) {
            System.out.println(testCase + ": " + isValidURL(testCase));
        }
    }
}