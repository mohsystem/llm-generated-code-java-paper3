package ourMethod.gemini;
import java.util.Arrays;
import java.util.Scanner;

public class Task104 {

    public static String handleUserInput(int bufferSize) {
        Scanner scanner = new Scanner(System.in);
        char[] buffer = new char[bufferSize];
        int index = 0;

        System.out.print("Enter input: ");
        String input = scanner.nextLine();

        if (input.length() > bufferSize) {
            return "Input exceeds buffer size.";
        }

        for (char c : input.toCharArray()) {
            buffer[index++] = c;
        }


        return new String(buffer, 0, input.length());
    }

    public static void main(String[] args) {
        System.out.println(handleUserInput(10)); // Test case 1
        System.out.println(handleUserInput(5)); // Test case 2
        System.out.println(handleUserInput(20)); // Test case 3
        System.out.println(handleUserInput(1)); // Test case 4
        System.out.println(handleUserInput(0)); // Test case 5

    }
}