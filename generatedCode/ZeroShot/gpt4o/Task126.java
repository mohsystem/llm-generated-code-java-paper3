package ZeroShot.openai;
import java.util.HashMap;
import java.util.Map;

public class Task126 {
    public static String redirectToPage(String userInput) {
        Map<String, String> pageMap = new HashMap<>();
        pageMap.put("home", "HomePage");
        pageMap.put("profile", "UserProfilePage");
        pageMap.put("settings", "SettingsPage");
        pageMap.put("help", "HelpPage");
        pageMap.put("contact", "ContactPage");

        return pageMap.getOrDefault(userInput.toLowerCase(), "ErrorPage");
    }

    public static void main(String[] args) {
        System.out.println(redirectToPage("home"));
        System.out.println(redirectToPage("PROFILE"));
        System.out.println(redirectToPage("Settings"));
        System.out.println(redirectToPage("Help"));
        System.out.println(redirectToPage("unknown"));
    }
}