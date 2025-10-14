package CoT.openai;
import java.util.Scanner;

public class Task41 {
    public static String processInput(String input) {
        // Process the input as needed. Here, we'll simply return the input for demonstration.
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a string: ");
            String userInput = scanner.nextLine();
            String result = processInput(userInput);
            System.out.println("Processed string: " + result);
        }
        scanner.close();
    }
}