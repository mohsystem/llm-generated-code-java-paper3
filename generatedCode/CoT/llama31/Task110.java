package CoT.llama31;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task110 {
    public static boolean isValidURL(String url) {
        String regex = "((http|https)://)(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "https://www.geeksforgeeks.org",
            "http://www.google.com",
            "https:// www.geeksforgeeks.org/", // Invalid due to space
            "http:/www.google.com", // Invalid due to missing '/'
            "https://example.com"
        };

        for (String testCase : testCases) {
            if (isValidURL(testCase)) {
                System.out.println(testCase + " is valid");
            } else {
                System.out.println(testCase + " is invalid");
            }
        }
    }
}