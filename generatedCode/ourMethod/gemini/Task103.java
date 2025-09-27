package ourMethod.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task103 {
    public static boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }


        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*\\d.*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrongPassword("Test1")); //false
        System.out.println(isStrongPassword("TestTest1")); //true
        System.out.println(isStrongPassword("Testtest")); //false
        System.out.println(isStrongPassword("TestTest")); //false
        System.out.println(isStrongPassword("Test1234")); //false

    }
}