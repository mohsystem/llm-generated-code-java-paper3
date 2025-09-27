package Vanilla.claude;

import java.util.Scanner;

public class Task44 {
    public static String processInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Invalid input";
        }
        
        // Remove special characters and numbers
        input = input.replaceAll("[^a-zA-Z\\\\s]", "");
        
        // Convert to uppercase and reverse
        String processed = new StringBuilder(input.toUpperCase()).reverse().toString();
        
        return processed;
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World!",
            "Test123",
            "",
            "Special@#$Characters",
            "AbCdEf 123"
        };
        
        for(String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + processInput(test));
            System.out.println();
        }
    }
}
