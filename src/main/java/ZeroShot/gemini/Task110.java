package ZeroShot.gemini;
import java.net.MalformedURLException;
import java.net.URL;

public class Task110 {
    public static boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | java.net.URISyntaxException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidURL("https://www.example.com"));
        System.out.println(isValidURL("http://example.com"));
        System.out.println(isValidURL("ftp://ftp.example.com"));
        System.out.println(isValidURL("invalid-url"));
        System.out.println(isValidURL("https://www.example.com/path?query=string#fragment"));
    }
}