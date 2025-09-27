package ourMethod.gpt4o;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task45 {
    public static void main(String[] args) {
        Task45 task = new Task45();

        // Test cases
        System.out.println(task.handleInput(10, 2));
        System.out.println(task.handleInput(10, 0));
        System.out.println(task.handleInput(-5, 3));
        System.out.println(task.handleInput(20, 4));
        System.out.println(task.handleInput(0, 1));
    }

    public String handleInput(int a, int b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            int result = a / b;
            return "Result: " + result;
        } catch (ArithmeticException e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
    }
}