package ourMethodv2.gpt4o;
import java.util.Scanner;

public class Task104 {

    public static void handleInput(String input, int bufferSize) {
        if (input.length() > bufferSize) {
            System.out.println("Error: Input exceeds buffer size.");
            return;
        }
        char[] buffer = new char[bufferSize];
        for (int i = 0; i < input.length(); i++) {
            buffer[i] = input.charAt(i);
        }
        System.out.println("Stored in buffer: " + new String(buffer).trim());
    }

    public static void main(String[] args) {
        handleInput("Hello", 10);
        handleInput("World", 10);
        handleInput("ThisIsTooLongInput", 10);
        handleInput("Java", 10);
        handleInput("Buffer", 10);
    }
}