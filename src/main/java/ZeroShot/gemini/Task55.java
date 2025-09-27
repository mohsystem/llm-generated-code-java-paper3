package ZeroShot.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task55 {
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Task55 validator = new Task55();
        System.out.println(validator.isValidEmail("test@example.com")); // true
        System.out.println(validator.isValidEmail("invalid-email")); // false
        System.out.println(validator.isValidEmail("another.test@sub.example.co.uk")); // true
        System.out.println(validator.isValidEmail("test+category@gmail.com")); //true
        System.out.println(validator.isValidEmail("")); // false
    }
}