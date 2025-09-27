package ZeroShot.gemini;
import java.util.Arrays;
import java.util.Scanner;

class Task104 {
    public static String handleInput(String input, int bufferSize) {
        if (input.length() > bufferSize) {
            return input.substring(0, bufferSize);
        } else {
            return input;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(handleInput(scanner.nextLine(), 10));
        System.out.println(handleInput("This is a test string", 20));
        System.out.println(handleInput("Another test string", 10));
        System.out.println(handleInput("Short string", 20));
        System.out.println(handleInput("A very long string that exceeds the buffer size", 25));
        scanner.close();

    }
}