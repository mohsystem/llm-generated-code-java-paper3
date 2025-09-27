package ZeroShot.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task103 {
    public boolean isStrongPassword(String password) {
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
        Task103 checker = new Task103();
        System.out.println(checker.isStrongPassword("short")); //false
        System.out.println(checker.isStrongPassword("noNumbers")); //false
        System.out.println(checker.isStrongPassword("NoDigits"));//false
        System.out.println(checker.isStrongPassword("NoUpperCase1"));//false
        System.out.println(checker.isStrongPassword("CorrectPassword1"));//true
    }
}