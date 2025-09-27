package ZeroShot.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task109 {
    public boolean validateInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Task109 validator = new Task109();

        System.out.println(validator.validateInput("abc123xyz", "^[a-z0-9]+$")); // true
        System.out.println(validator.validateInput("abc 123 xyz", "^[a-z0-9]+$")); // false
        System.out.println(validator.validateInput("123-456-7890", "^\\d{3}-\\d{3}-\\d{4}$")); // true
        System.out.println(validator.validateInput("john.doe@example.com", "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")); // true
        System.out.println(validator.validateInput("password", "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")); // false

    }
}