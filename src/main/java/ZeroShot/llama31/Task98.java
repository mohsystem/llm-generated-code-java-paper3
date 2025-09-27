package ZeroShot.llama31;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task98 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a string to convert to integer: ");
            String input = scanner.nextLine();
            try {
                int result = convertStringToInt(input);
                System.out.println("Converted integer: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Cannot convert to integer");
            }
        }
        scanner.close();
    }

    public static int convertStringToInt(String str) {
        return Integer.parseInt(str);
    }
}