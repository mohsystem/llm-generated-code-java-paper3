package CoT.claude;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task39 {
    public static String displayFileContents(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Invalid filename";
        }
        
        try {
            // Validate file path
            Path filePath = Paths.get(filename).normalize();
            File file = filePath.toFile();
            
            // Security checks
            if (!file.exists()) {
                return "File does not exist";
            }
            if (!file.isFile()) {
                return "Not a regular file";
            }
            if (!file.canRead()) {
                return "File is not readable";
            }
            
            // Read file contents safely using Files API
            return new String(Files.readAllBytes(filePath));
            
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        } catch (SecurityException e) {
            return "Security error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.txt",
            "../test2.txt",  // Path traversal attempt
            "",             // Empty filename
            "nonexistent.txt",
            "/etc/passwd"   // Sensitive file access attempt
        };
        
        for (String file : testFiles) {
            System.out.println("Testing file: " + file);
            System.out.println(displayFileContents(file));
            System.out.println("------------------------");
        }
    }
}
