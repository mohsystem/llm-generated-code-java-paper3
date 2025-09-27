package Vanilla.gpt4o;
class Task126 {
    public static String redirectToPage(String userInput) {
        switch (userInput.toLowerCase()) {
            case "home":
                return "Redirecting to Home Page";
            case "profile":
                return "Redirecting to Profile Page";
            case "settings":
                return "Redirecting to Settings Page";
            case "help":
                return "Redirecting to Help Page";
            default:
                return "Page not found";
        }
    }
    
    public static void main(String[] args) {
        System.out.println(redirectToPage("home"));
        System.out.println(redirectToPage("profile"));
        System.out.println(redirectToPage("settings"));
        System.out.println(redirectToPage("help"));
        System.out.println(redirectToPage("logout"));
    }
}