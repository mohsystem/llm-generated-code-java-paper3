package ourMethod.gemini;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task71 {

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Or throw an exception, or return a special value indicating failure
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(stringToInt("123"));      // Output: 123
        System.out.println(stringToInt("-456"));     // Output: -456
        System.out.println(stringToInt("0"));        // Output: 0
        System.out.println(stringToInt("123a"));    // Output: -1
        System.out.println(stringToInt("123.45"));  // Output: -1


        if (args.length > 0) {
            for (String arg : args) {
                int result = stringToInt(arg);
                if (result != -1) {
                    System.out.println("Successfully converted " + arg + " to integer: " + result);
                } else {
                    System.out.println("Failed to convert " + arg + " to integer.");
                }
            }

        } else {
            System.out.println("No command line arguments provided.");


            Scanner scanner = new Scanner(System.in);


            try {
                System.out.print("Enter a string: ");
                String input = scanner.next();
                int result = stringToInt(input);
                if (result != -1) {
                    System.out.println("Successfully converted to integer: " + result);
                } else {
                    System.out.println("Failed to convert to integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid string.");
            } finally {
                scanner.close();
            }


        }
    }
}