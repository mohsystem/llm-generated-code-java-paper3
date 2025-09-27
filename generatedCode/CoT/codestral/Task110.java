package CoT.codestral;
import java.util.regex.Pattern;

public class Task110 {
    private static final Pattern URL_PATTERN = Pattern.compile(
            "^(https?|ftp|file)://" + // protocol
            "[\\w-]+(\\.[\\w-]+)+" + // domain
            "(/[\\w.-]*)*" + // path
            "(\\?[\\w.-]+=\\w*)*" + // query
            "?$");

    public static boolean isValidUrl(String url) {
        return URL_PATTERN.matcher(url).matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidUrl("http://www.google.com")); // true
        System.out.println(isValidUrl("https://stackoverflow.com/questions/163360/regular-expression-to-match-urls-in-java")); // true
        System.out.println(isValidUrl("ftp://ftp.example.com/")); // true
        System.out.println(isValidUrl("file:///C:/path/to/file.txt")); // true
        System.out.println(isValidUrl("invalid-url")); // false
    }
}