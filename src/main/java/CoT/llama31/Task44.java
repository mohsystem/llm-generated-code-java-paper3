package CoT.llama31;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            try {
                System.out.print("Enter an integer: ");
                int input = scanner.nextInt();
                int result = square(input);
                System.out.println("The square of " + input + " is " + result);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.close();
    }

    public static int square(int num) {
        return num * num;
    }
}