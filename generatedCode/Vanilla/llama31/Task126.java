package Vanilla.llama31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task126 {
    public static void main(String[] args) throws IOException {
        int lines = 0;
        int words = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                words += line.split("\\s+").length;
            }
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
        }
    }

    public static void countLinesAndWords() throws IOException {
        int lines = 0;
        int words = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                words += line.split("\\s+").length;
            }
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
        }
    }

    public static void main(String[] args) throws IOException {
        // Test cases
        System.out.println("Test Case 1:");
        countLinesAndWords();

        System.out.println("\nTest Case 2:");
        countLinesAndWords();

        System.out.println("\nTest Case 3:");
        countLinesAndWords();

        System.out.println("\nTest Case 4:");
        countLinesAndWords();

        System.out.println("\nTest Case 5:");
        countLinesAndWords();
    }
}