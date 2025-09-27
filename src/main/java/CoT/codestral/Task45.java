package CoT.codestral;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a number: ");
            int num = scanner.nextInt();
            System.out.println("The square of the number is: " + square(num));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        } finally {
            scanner.close();
        }
    }

    public static int square(int num) {
        return num * num;
    }
}