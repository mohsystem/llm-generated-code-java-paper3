package ZeroShot.codestral;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task73 {
    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Admin@123")); // true
        System.out.println(isValidPassword("admin123")); // false
        System.out.println(isValidPassword("Admin123")); // false
        System.out.println(isValidPassword("Admin@12")); // false
        System.out.println(isValidPassword("Admin@1234")); // true
    }
}