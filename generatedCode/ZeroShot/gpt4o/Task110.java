package ZeroShot.gpt4o;
import java.util.regex.*;

public class Task110 {
    public static boolean isValidURL(String url) {
        String regex = "^(https?|ftp)://[\\w.-]+(:\\d+)?(/([\\w/_.]*)?)?$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidURL("http://example.com")); // true
        System.out.println(isValidURL("https://www.example.com/path/to/resource")); // true
        System.out.println(isValidURL("ftp://example.com/file.txt")); // true
        System.out.println(isValidURL("htt://wrongprotocol.com")); // false
        System.out.println(isValidURL("http://invalid-url")); // false
    }
}