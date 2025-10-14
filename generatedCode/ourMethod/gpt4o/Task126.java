package ourMethod.openai;
import java.util.HashMap;
import java.util.Map;

public class Task126 {
    public static String redirectUser(String userInput) {
        Map<String, String> pageMap = new HashMap<>();
        pageMap.put("home", "HomePage");
        pageMap.put("about", "AboutPage");
        pageMap.put("contact", "ContactPage");
        pageMap.put("services", "ServicesPage");
        pageMap.put("login", "LoginPage");

        String safeInput = sanitizeInput(userInput.toLowerCase());
        return pageMap.getOrDefault(safeInput, "ErrorPage");
    }

    private static String sanitizeInput(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static void main(String[] args) {
        System.out.println(redirectUser("home"));
        System.out.println(redirectUser("about"));
        System.out.println(redirectUser("contact"));
        System.out.println(redirectUser("services"));
        System.out.println(redirectUser("unknown"));
    }
}