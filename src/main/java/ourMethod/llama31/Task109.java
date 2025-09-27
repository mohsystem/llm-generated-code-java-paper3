package ourMethod.llama31;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task109 {
    public static boolean validateInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] inputs = {"test@example.com", "invalid-email", "123-456-7890", "invalid-phone"};
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String phoneRegex = "^\\d{3}-\\d{3}-\\d{4}$";

        System.out.println("Email: " + inputs[0] + " - " + validateInput(inputs[0], emailRegex));
        System.out.println("Email: " + inputs[1] + " - " + validateInput(inputs[1], emailRegex));
        System.out.println("Phone: " + inputs[2] + " - " + validateInput(inputs[2], phoneRegex));
        System.out.println("Phone: " + inputs[3] + " - " + validateInput(inputs[3], phoneRegex));
    }
}