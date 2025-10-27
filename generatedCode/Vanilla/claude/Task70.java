package Vanilla.claude;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task70 {
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.txt",
            "nonexistent.txt",
            "sample.txt",
            "empty.txt",
            "data.txt"
        };

        for (String file : testFiles) {
            System.out.println("Reading file: " + file);
            System.out.println("Content:");
            System.out.println(readFile(file));
            System.out.println("------------------------");
        }
    }
}
