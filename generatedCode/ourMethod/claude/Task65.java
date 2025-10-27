package ourMethod.claude;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task65 {
    public static String readFile(String filename) {
        // Validate filename is not null or empty
        if (filename == null || filename.trim().isEmpty()) {
            return "Error: Invalid filename - filename cannot be null or empty";
        }

        // Validate file path format and normalize
        Path normalizedPath;
        try {
            normalizedPath = Paths.get(filename).normalize();
        } catch (Exception e) {
            return "Error: Invalid filename format";
        }

        // Convert to file
        File file = normalizedPath.toFile();

        // Validate file exists and is accessible
        if (!file.exists()) {
            return "Error: File does not exist";
        }
        if (!file.isFile()) {
            return "Error: Path is not a regular file";
        }
        if (!file.canRead()) {
            return "Error: File is not readable";
        }

        // Read file contents
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Error: Failed to read file - " + e.getMessage();
        }

        return content.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            null,                    // Test null filename
            "",                      // Test empty filename  
            "nonexistent.txt",       // Test non-existent file
            "/etc/passwd",           // Test unauthorized access
            "../../test.txt",        // Test path traversal
            "test.txt"              // Test valid file
        };

        for (String testFile : testFiles) {
            System.out.println("\\nTesting file: " + testFile);
            System.out.println(readFile(testFile));
        }
    }
}
