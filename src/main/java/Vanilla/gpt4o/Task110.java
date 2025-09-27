package Vanilla.gpt4o;
import java.util.regex.*;

public class Task110 {
    public static boolean validateURL(String url) {
        String regex = "^(https?|ftp)://[\\w.-]+(?:\\.[\\w\\.-]+)+[/\\w\\-\\._~:/?#[\\]@!$&'()*+,;=.]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        System.out.println(validateURL("http://example.com")); // true
        System.out.println(validateURL("https://www.example.com/test")); // true
        System.out.println(validateURL("ftp://example.com/resource")); // true
        System.out.println(validateURL("htp://example.com")); // false
        System.out.println(validateURL("http://.com")); // false
    }
}