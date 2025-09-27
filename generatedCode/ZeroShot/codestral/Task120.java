package ZeroShot.codestral;
import java.util.Scanner;

public class Task120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter some input:");
        String userInput = scanner.nextLine();
        displayOnWebPage(userInput);
    }

    public static void displayOnWebPage(String input) {
        // In a real-world application, this would involve sending the input to a web page.
        System.out.println("Displaying on web page: " + input);
    }
}