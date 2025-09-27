package ourMethod.gemini;
import java.util.Scanner;

public class Task126 {

    public static String redirect(String input) {
        if (input == null) {
            return "Invalid input";
        }

        String redirectPage;
        switch (input.toLowerCase()) {
            case "home":
                redirectPage = "/home";
                break;
            case "profile":
                redirectPage = "/profile";
                break;
            case "settings":
                redirectPage = "/settings";
                break;
            default:
                redirectPage = "/error";
        }
        return redirectPage;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your input: ");

        String input1 = scanner.nextLine();
        System.out.println("Redirect page for " + input1 + ": " + redirect(input1));

        String input2 = "profile";
        System.out.println("Redirect page for " + input2 + ": " + redirect(input2));

        String input3 = "SETTINGS";
        System.out.println("Redirect page for " + input3 + ": " + redirect(input3));

        String input4 = "invalid";
        System.out.println("Redirect page for " + input4 + ": " + redirect(input4));
        
        String input5 = null;
        System.out.println("Redirect page for " + input5 + ": " + redirect(input5));

        scanner.close();
    }
}