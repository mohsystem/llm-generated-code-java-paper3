package ZeroShot.codestral;
import java.net.URL;
import java.net.MalformedURLException;

public class Task110 {
    public static boolean isValidURL(String url) {
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidURL("https://www.google.com")); // true
        System.out.println(isValidURL("http://stackoverflow.com")); // true
        System.out.println(isValidURL("ftp://example.com")); // true
        System.out.println(isValidURL("www.google.com")); // false, missing protocol
        System.out.println(isValidURL("google.com")); // false, missing protocol
    }
}