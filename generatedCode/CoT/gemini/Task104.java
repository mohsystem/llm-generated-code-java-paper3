package CoT.gemini;
import java.util.Arrays;
import java.util.Scanner;

public class Task104 {

    public static String handleInput(int bufferSize, Scanner scanner) {
        char[] buffer = new char[bufferSize];
        int index = 0;

        while (scanner.hasNext() && index < bufferSize) {
            String input = scanner.next();
            for (int i = 0; i < input.length() && index < bufferSize; i++) {
                buffer[index++] = input.charAt(i);
            }
        }
        return new String(Arrays.copyOf(buffer, index));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(handleInput(10, new Scanner("This is a test input")));
        System.out.println(handleInput(5, new Scanner("Short")));
        System.out.println(handleInput(20, new Scanner("A longer input string")));
        System.out.println(handleInput(7, new Scanner("Input with spaces")));
        System.out.println(handleInput(15, new Scanner("Special characters like !@#$%^")));

        scanner.close();

    }
}