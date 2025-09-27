package Vanilla.codestral;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task98 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String input = scanner.nextLine();
        try {
            int output = Integer.parseInt(input);
            System.out.println("The number is: " + output);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}