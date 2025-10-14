package ourMethodv2.gpt4o;
import java.net.URL;
import java.util.regex.Pattern;

public class Task110 {
    public static boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidURL("https://www.example.com")); // true
        System.out.println(isValidURL("http://invalid-url")); // false
        System.out.println(isValidURL("ftp://valid-ftp.com")); // true
        System.out.println(isValidURL("not-a-url")); // false
        System.out.println(isValidURL("http://www.test.com")); // true
    }
}