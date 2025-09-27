package ourMethod.codestral;
import java.net.URL;
import java.net.MalformedURLException;

public class Task110 {
    public static boolean isValidURL(String url) {
        try {
            new URL(url);
            return url.startsWith("http://") || url.startsWith("https://");
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] urls = {"http://example.com", "https://example.com", "ftp://example.com", "http://", "invalid"};
        for (String url : urls) {
            System.out.println(url + " is valid? " + isValidURL(url));
        }
    }
}