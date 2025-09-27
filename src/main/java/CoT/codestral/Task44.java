package CoT.codestral;
import java.util.Scanner;

public class Task44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            System.out.println("Square of the number is: " + square(num));
        } else {
            System.out.println("Invalid input. Please enter a number.");
        }
        scanner.close();
    }

    public static int square(int num) {
        return num * num;
    }
}