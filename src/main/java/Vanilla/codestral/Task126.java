package Vanilla.codestral;
public class Task126 {
    public static String redirectPage(String userInput) {
        switch (userInput) {
            case "home":
                return "Home Page";
            case "profile":
                return "Profile Page";
            case "settings":
                return "Settings Page";
            default:
                return "Error 404: Page Not Found";
        }
    }

    public static void main(String[] args) {
        System.out.println(redirectPage("home"));
        System.out.println(redirectPage("profile"));
        System.out.println(redirectPage("settings"));
        System.out.println(redirectPage("blog"));
        System.out.println(redirectPage("contact"));
    }
}