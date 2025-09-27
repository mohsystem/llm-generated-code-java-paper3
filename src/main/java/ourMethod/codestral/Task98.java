package ourMethod.codestral;
import java.util.Scanner;

public class Task98 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        String input = scanner.nextLine();

        try {
            int num = Integer.parseInt(input);
            System.out.println("You entered: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }
}