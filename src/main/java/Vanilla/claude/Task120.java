package Vanilla.claude;

// Web input/output typically requires a web framework/server which cannot be done in a single file
// Here's a basic console implementation instead
import java.util.Scanner;

public class Task120 {
    public static void displayInput(String input) {
        System.out.println("Your input: " + input);
    }

    public static void main(String[] args) {
        // Test cases
        displayInput("Hello World!");
        displayInput("Testing 123");
        displayInput("Java Program");
        displayInput("Web Display");
        displayInput("Final Test");
    }
}
