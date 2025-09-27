package CoT.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task103 {
    public static boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);
        if (!uppercaseMatcher.find()) {
            return false;
        }

        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Matcher lowercaseMatcher = lowercasePattern.matcher(password);
        if (!lowercaseMatcher.find()) {
            return false;
        }

        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(password);
        if (!digitMatcher.find()) {
            return false;
        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrongPassword("Test1")); //false
        System.out.println(isStrongPassword("TestTest1")); //true
        System.out.println(isStrongPassword("TestTest")); //false
        System.out.println(isStrongPassword("testtest1")); //false
        System.out.println(isStrongPassword("TESTTEST1")); //false
    }
}