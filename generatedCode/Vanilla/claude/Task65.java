package Vanilla.claude;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task65 {
    public static String readFile(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Error: Invalid filename";
        }

        File file = new File(filename);
        if (!file.exists()) {
            return "Error: File does not exist";
        }

        if (!file.canRead()) {
            return "Error: File is not readable";
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.txt",           // Non-existent file
            "",                    // Empty filename
            null,                  // Null filename
            "/root/secret.txt",    // No permission file
            "sample.txt"           // Valid file (create this file for testing)
        };

        for (String filename : testFiles) {
            System.out.println("Testing filename: " + filename);
            System.out.println(readFile(filename));
            System.out.println("-------------------");
        }
    }
}
