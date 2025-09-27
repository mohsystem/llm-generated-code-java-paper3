package ourMethod.codestral;
import java.util.Scanner;

public class Task44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String input = scanner.nextLine();
        if (isValidNumber(input)) {
            int number = Integer.parseInt(input);
            // Perform operations here
        } else {
            System.out.println("Invalid input");
        }
    }

    private static boolean isValidNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}