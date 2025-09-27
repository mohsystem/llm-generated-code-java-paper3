package ourMethod.gpt4o;
import java.util.Arrays;

public class Task104 {
    private static final int BUFFER_SIZE = 10;

    public String handleInput(String input) {
        char[] buffer = new char[BUFFER_SIZE];
        Arrays.fill(buffer, '\0');

        for (int i = 0; i < BUFFER_SIZE && i < input.length(); i++) {
            buffer[i] = input.charAt(i);
        }

        return new String(buffer).trim();
    }

    public static void main(String[] args) {
        Task104 task = new Task104();

        System.out.println(task.handleInput("Hello"));
        System.out.println(task.handleInput("World!"));
        System.out.println(task.handleInput("1234567890"));
        System.out.println(task.handleInput("More than ten characters"));
        System.out.println(task.handleInput(""));
    }
}