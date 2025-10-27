package Vanilla.claude;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task36 {
    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test 1: " + readFile("test1.txt"));
        System.out.println("Test 2: " + readFile("nonexistent.txt"));
        System.out.println("Test 3: " + readFile("empty.txt"));
        System.out.println("Test 4: " + readFile("large.txt"));
        System.out.println("Test 5: " + readFile("special_chars.txt"));
    }
}
