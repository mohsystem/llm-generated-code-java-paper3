package CoT.gpt4o;
import java.util.Scanner;

public class Task126 {
    public static String redirectUser(String input) {
        switch (input.toLowerCase()) {
            case "home":
                return "Redirecting to Home Page...";
            case "profile":
                return "Redirecting to Profile Page...";
            case "settings":
                return "Redirecting to Settings Page...";
            case "logout":
                return "Redirecting to Logout Page...";
            default:
                return "Unknown page requested.";
        }
    }

    public static void main(String[] args) {
        String[] testInputs = {"home", "profile", "settings", "logout", "unknown"};
        for (String input : testInputs) {
            System.out.println("Input: " + input + " -> " + redirectUser(input));
        }
    }
}