package Vanilla.llama31;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Task110 {
    public static boolean validateURL(String urlString) {
        try {
            new URL(urlString).toURI();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {"https://www.geeksforgeeks.org", "http://example.com", "invalid url", "https://www.example.com/path?query=param", "ftp://example.com"};
        for (String testCase : testCases) {
            System.out.println(testCase + ": " + validateURL(testCase));
        }
    }
}