package Vanilla.gemini;
import java.net.URL;
import java.net.MalformedURLException;

class Task110 {
    public boolean isValidURL(String url) {
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Task110 validator = new Task110();
        System.out.println(validator.isValidURL("https://www.example.com")); // true
        System.out.println(validator.isValidURL("http://example.com")); // true
        System.out.println(validator.isValidURL("ftp://ftp.example.com")); // true
        System.out.println(validator.isValidURL("example.com")); // false
        System.out.println(validator.isValidURL("htt://example.com")); // false

    }
}