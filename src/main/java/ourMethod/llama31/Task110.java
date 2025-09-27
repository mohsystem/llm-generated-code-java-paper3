package ourMethod.llama31;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task110 {
    public static boolean isValidURL(String url) {
        // Regex to check valid URL
        String regex = "((http|https)://)(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "https://www.geeksforgeeks.org",
            "https:// www.geeksforgeeks.org/", // Invalid due to space
            "http://example.com",
            "http://example.com/path",
            "https://example.com/path?query=param"
        };

        for (String testCase : testCases) {
            if (isValidURL(testCase)) {
                System.out.println("Yes, the URL is valid: " + testCase);
            } else {
                System.out.println("No, the URL is not valid: " + testCase);
            }
        }
    }
}