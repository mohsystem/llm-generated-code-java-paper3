package ourMethodv2.gpt4o;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task120 {

    public static String displayInputOnWebPage(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            return "Invalid input";
        }

        // Simple validation to allow only alphanumeric input and space
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9 ]+$");
        Matcher matcher = pattern.matcher(userInput);

        if (!matcher.matches()) {
            return "Invalid input";
        }

        return "<html><body><p>" + userInput + "</p></body></html>";
    }

    public static void main(String[] args) {
        System.out.println(displayInputOnWebPage("Hello World"));
        System.out.println(displayInputOnWebPage("Welcome123"));
        System.out.println(displayInputOnWebPage("!@#"));
        System.out.println(displayInputOnWebPage(null));
        System.out.println(displayInputOnWebPage("Java C++ Python"));
    }
}