package ZeroShot.gpt4o;
import java.util.regex.*;

public class Task73 {
    public static boolean isValidPassword(String password) {
        if (password == null) return false;
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$).{8,}$";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Admin123!")); // true
        System.out.println(isValidPassword("admin123!")); // false
        System.out.println(isValidPassword("ADMIN123!")); // false
        System.out.println(isValidPassword("Admin!"));    // false
        System.out.println(isValidPassword("Admin123456")); // false
    }
}