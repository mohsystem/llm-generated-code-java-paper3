package CoT.claude;

import java.io.*;
import java.nio.file.*;

public class Task65 {
    public static String readFile(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Error: Filename cannot be null or empty";
        }

        // Validate filename format
        if (!filename.matches("^[a-zA-Z0-9._-]+$")) {
            return "Error: Invalid filename format";
        }

        try {
            // Check if file exists
            if (!Files.exists(Paths.get(filename))) {
                return "Error: File does not exist";
            }

            // Check if file is readable
            if (!Files.isReadable(Paths.get(filename))) {
                return "Error: File is not accessible";
            }

            // Read file content
            return new String(Files.readAllBytes(Paths.get(filename)));

        } catch (SecurityException e) {
            return "Error: Security violation accessing file";
        } catch (IOException e) {
            return "Error: Unable to read file";
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test.txt",           // Normal case
            null,                // Null filename
            "",                  // Empty filename
            "invalid*file.txt",  // Invalid format
            "nonexistent.txt"    // Non-existent file
        };

        for (String file : testFiles) {
            System.out.println("Testing file: " + file);
            System.out.println(readFile(file));
            System.out.println("-------------------");
        }
    }
}
