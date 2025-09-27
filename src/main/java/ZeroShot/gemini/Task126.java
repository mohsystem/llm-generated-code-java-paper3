package ZeroShot.gemini;
import java.util.Scanner;

class Task126 {
    public String redirect(String userInput) {
        String redirectUrl = "";

        // Validate user input to prevent vulnerabilities like XSS or open redirects
        if (userInput != null && userInput.matches("^[a-zA-Z0-9]+$")) { // Example: Allow only alphanumeric input

            switch (userInput) {
                case "home":
                    redirectUrl = "/home";
                    break;
                case "profile":
                    redirectUrl = "/profile";
                    break;
                case "settings":
                    redirectUrl = "/settings";
                    break;
                default:
                    redirectUrl = "/error"; // Redirect to an error page for invalid input
            }
        } else {
            redirectUrl = "/error";
        }

        return redirectUrl;

    }


    public static void main(String[] args) {
        Task126 task = new Task126();
        Scanner scanner = new Scanner(System.in);

        System.out.println(task.redirect("home"));
        System.out.println(task.redirect("profile"));
        System.out.println(task.redirect("settings"));
        System.out.println(task.redirect("invalid"));
        System.out.println(task.redirect("<script>alert('XSS')</script>"));


    }
}