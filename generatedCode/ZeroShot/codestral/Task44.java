package ZeroShot.codestral;
import java.util.Scanner;

public class Task44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a number:");
            String input = scanner.nextLine();
            if (isValidNumber(input)) {
                int num = Integer.parseInt(input);
                System.out.println("Number squared is: " + square(num));
            } else {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        scanner.close();
    }

    private static boolean isValidNumber(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    private static int square(int num) {
        return num * num;
    }
}