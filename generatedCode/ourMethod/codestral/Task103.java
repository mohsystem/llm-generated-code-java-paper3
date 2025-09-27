package ourMethod.codestral;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task103 {
    public static boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        Pattern upperCase = Pattern.compile("[A-Z]");
        Pattern lowerCase = Pattern.compile("[a-z]");
        Pattern digit = Pattern.compile("[0-9]");

        Matcher hasUpperCase = upperCase.matcher(password);
        Matcher hasLowerCase = lowerCase.matcher(password);
        Matcher hasDigit = digit.matcher(password);

        return hasUpperCase.find() && hasLowerCase.find() && hasDigit.find();
    }

    public static void main(String[] args) {
        System.out.println(isStrongPassword("StrongPwd1"));  // true
        System.out.println(isStrongPassword("weakpassword")); // false
        System.out.println(isStrongPassword("WeakPwd"));      // false
        System.out.println(isStrongPassword("StrongPwd"));     // false
        System.out.println(isStrongPassword("Strong1"));       // false
    }
}