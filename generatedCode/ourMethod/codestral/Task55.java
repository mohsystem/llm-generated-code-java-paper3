package ourMethod.codestral;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task55 {
    public static boolean isValidEmail(String email) {
        String regex = "^[a-z0-9]+[\\._]?[a-z0-9]+[@]\\w+[.]\\w{2,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"};
        for (String email : emails) {
            System.out.println(email + ": " + isValidEmail(email));
        }
    }
}