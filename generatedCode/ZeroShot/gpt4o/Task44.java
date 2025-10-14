package ZeroShot.openai;
import java.util.Scanner;

public class Task44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test cases
        System.out.println(safeOperation("123"));
        System.out.println(safeOperation("456"));
        System.out.println(safeOperation("hello"));
        System.out.println(safeOperation("789"));
        System.out.println(safeOperation("0"));

        scanner.close();
    }

    public static int safeOperation(String userInput) {
        if (isValidInput(userInput)) {
            return Integer.parseInt(userInput) * 2;
        } else {
            return -1; // Invalid input
        }
    }

    private static boolean isValidInput(String input) {
        return input.matches("\\d+");
    }
}