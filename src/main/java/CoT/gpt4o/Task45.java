package CoT.gpt4o;
import java.util.Scanner;

public class Task45 {
    public static int processInput(int input) {
        try {
            if (input < 0) {
                throw new IllegalArgumentException("Negative input not allowed.");
            }
            return input * 2;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] testInputs = {10, -5, 15, 0, 3};
        for (int input : testInputs) {
            System.out.println("Processing input: " + input);
            int result = processInput(input);
            System.out.println("Result: " + result);
        }
        scanner.close();
    }
}