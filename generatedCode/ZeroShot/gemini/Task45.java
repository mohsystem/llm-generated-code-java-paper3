package ZeroShot.gemini;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task45 {

    public static int safeIntegerInput(Scanner scanner) {
        int num = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter an integer: ");
                num = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }
        return num;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = safeIntegerInput(scanner);
        int num2 = safeIntegerInput(scanner);

        try {
            int result = num1 / num2;
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero.");
        }


        scanner.close();


        //test cases
        test(10,2);
        test(5,0);
        test(8,4);
        test(12,3);
        test(7,0);

    }
    public static void test(int num1, int num2){
       try {
            int result = num1 / num2;
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero.");
        }
    }
}