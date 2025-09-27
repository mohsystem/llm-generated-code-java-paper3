package CoT.gemini;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task110 {

    public static boolean isValidURL(String url) {
        try {
            new URL(url);
            // Basic URL pattern check (improve as needed)
            String regex = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(url);

            return matcher.matches();
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] testUrls = {
                "https://www.example.com",
                "http://example.com",
                "ftp://ftp.example.com",
                "invalid-url",
                "https://www.example.com/path?query=string#fragment"
        };

        for (String url : testUrls) {
            System.out.println(url + ": " + isValidURL(url));
        }
    }
}