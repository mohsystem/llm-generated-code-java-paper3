package CoT.codestral;
import java.util.Scanner;

public class Task98 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                System.out.println("Converted number: " + number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        scanner.close();
    }

    public static int convertToInt(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }
}