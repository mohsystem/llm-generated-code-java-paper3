package ZeroShot.gpt4o;
import java.util.Scanner;

public class Task98 {
    public static Integer convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            String input = scanner.nextLine();
            Integer result = convertToInt(input);
            if (result != null) {
                System.out.println("Converted: " + result);
            } else {
                System.out.println("Invalid input, not an integer.");
            }
        }
        scanner.close();
    }
}