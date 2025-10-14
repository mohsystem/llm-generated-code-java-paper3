package ourMethodv2.gpt4o;
import java.util.HashMap;
import java.util.Map;

public class Task126 {
    private static final Map<String, String> pageRedirects = new HashMap<>();

    static {
        pageRedirects.put("home", "/home.html");
        pageRedirects.put("contact", "/contact.html");
        pageRedirects.put("about", "/about.html");
        pageRedirects.put("services", "/services.html");
        pageRedirects.put("help", "/help.html");
    }

    public static String redirectToPage(String userInput) {
        if (userInput == null || !pageRedirects.containsKey(userInput)) {
            return "Invalid input or page not found.";
        }
        return "Redirecting to " + pageRedirects.get(userInput);
    }

    public static void main(String[] args) {
        System.out.println(redirectToPage("home"));
        System.out.println(redirectToPage("contact"));
        System.out.println(redirectToPage("about"));
        System.out.println(redirectToPage("services"));
        System.out.println(redirectToPage("unknown"));
    }
}