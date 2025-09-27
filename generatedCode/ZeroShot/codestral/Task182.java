package ZeroShot.codestral;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task182 {
    public static String cleanPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.replaceAll("");
    }

    public static void main(String[] args) {
        String[] testCases = {"+1 (613)-995-0253", "613-995-0253", "1 613 995 0253", "613.995.0253"};
        for (String testCase : testCases) {
            System.out.println(cleanPhoneNumber(testCase));
        }
    }
}