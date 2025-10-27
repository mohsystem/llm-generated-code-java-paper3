package CoT.claude;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task70 {
    public static String readFile(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            return "Invalid file path";
        }

        StringBuilder content = new StringBuilder();
        try {
            // Normalize and validate path
            Path normalizedPath = Paths.get(filePath).normalize();
            File file = normalizedPath.toFile();
            
            // Security checks
            if (!file.exists()) {
                return "File does not exist";
            }
            if (!file.isFile()) {
                return "Not a regular file";
            }
            if (!file.canRead()) {
                return "File cannot be read";
            }
            
            // Read file content securely
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }
            return content.toString();
            
        } catch (SecurityException e) {
            return "Security error: Access denied";
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide file path as argument");
            return;
        }
        
        // Test cases
        String[] testFiles = {
            args[0],                    // User provided file
            "test1.txt",               // Regular file
            "/etc/passwd",             // System file
            "../test2.txt",            // Parent directory file
            "nonexistent.txt"          // Non-existent file
        };
        
        for (String file : testFiles) {
            System.out.println("\\nReading file: " + file);
            System.out.println("Content:\\n" + readFile(file));
        }
    }
}
