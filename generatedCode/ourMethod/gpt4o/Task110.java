package ourMethod.openai;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task110 {

    public static boolean isValidURL(String url) {
        String urlPattern = "^(https?|ftp)://[a-zA-Z0-9.-]+(:[0-9]+)?(/.*)?$";
        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidURL("http://example.com")); // true
        System.out.println(isValidURL("https://example.com")); // true
        System.out.println(isValidURL("ftp://example.com")); // true
        System.out.println(isValidURL("http://example.com:8080")); // true
        System.out.println(isValidURL("http://example.com/path/to/resource")); // true
    }
}