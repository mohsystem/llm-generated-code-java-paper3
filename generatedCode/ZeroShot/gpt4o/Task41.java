package ZeroShot.gpt4o;
import java.util.Scanner;

public class Task41 {
    public static String processString(String input) {
        // Secure processing logic
        if (input == null) {
            return "";
        }
        // Example processing: Reverse the input string
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            String result = processString(input);
            System.out.println("Processed string: " + result);
        }
        scanner.close();
    }
}