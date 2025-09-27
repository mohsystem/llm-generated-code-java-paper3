package CoT.codestral;
// Java code
import java.util.Scanner;

public class Task126 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your input: ");
        String userInput = scanner.nextLine();
        redirectUser(userInput);
        scanner.close();
    }

    public static void redirectUser(String input) {
        switch (input.toLowerCase()) {
            case "home":
                System.out.println("Redirecting to home page...");
                // Add your redirecting logic here
                break;
            case "about":
                System.out.println("Redirecting to about page...");
                // Add your redirecting logic here
                break;
            case "contact":
                System.out.println("Redirecting to contact page...");
                // Add your redirecting logic here
                break;
            default:
                System.out.println("Invalid input. Redirecting to default page...");
                // Add your redirecting logic here
                break;
        }
    }
}