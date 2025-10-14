package Vanilla.openai;
import java.util.Scanner;

public class Task41 {
    public static String processString(String input) {
        // Process the string and return it, here we just return the input for simplicity
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        
        for (int i = 0; i < 5; i++) {
            String input = scanner.nextLine();
            String output = processString(input);
            System.out.println("Processed string: " + output);
        }
        
        scanner.close();
    }
}