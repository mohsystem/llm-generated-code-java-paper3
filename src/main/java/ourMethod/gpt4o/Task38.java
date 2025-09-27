package ourMethod.gpt4o;
import java.util.Scanner;

class Task38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Five test cases
        System.out.println(handleInput("Hello, World!"));
        System.out.println(handleInput("Java Programming"));
        System.out.println(handleInput("123456"));
        System.out.println(handleInput("Secure Code"));
        System.out.println(handleInput("Test Input"));

        scanner.close();
    }

    public static String handleInput(String input) {
        // Simulate returning user input
        return "You entered: " + input;
    }
}