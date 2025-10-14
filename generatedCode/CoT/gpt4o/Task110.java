package CoT.openai;
import java.net.MalformedURLException;
import java.net.URL;

public class Task110 {
    public static boolean validateURL(String url) {
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validateURL("http://example.com")); // true
        System.out.println(validateURL("https://example.com")); // true
        System.out.println(validateURL("ftp://example.com")); // true
        System.out.println(validateURL("invalid://example.com")); // false
        System.out.println(validateURL("example.com")); // false
    }
}