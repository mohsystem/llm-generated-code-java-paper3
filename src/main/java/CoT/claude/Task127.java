package CoT.claude;

import java.io.*;
import java.nio.file.*;

public class Task127 {
    public static boolean copyFileToTemp(String sourcePath) {
        try {
            // Validate input path
            if (sourcePath == null || sourcePath.trim().isEmpty()) {
                throw new IllegalArgumentException("Source path cannot be null or empty");
            }

            // Create Path objects
            Path source = Paths.get(sourcePath);
            Path temp = Files.createTempFile("temp_", ".tmp");

            // Validate source file
            if (!Files.exists(source)) {
                throw new FileNotFoundException("Source file does not exist");
            }
            if (!Files.isReadable(source)) {
                throw new SecurityException("Source file is not readable");
            }

            // Copy file with security checks
            Files.copy(source, temp, StandardCopyOption.REPLACE_EXISTING);
            
            return true;
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
            return false;
        } catch (SecurityException e) {
            System.err.println("Security Error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testPaths = {
            "test1.txt",                    // Non-existent file
            null,                           // Null path
            "",                             // Empty path
            "src/main/resources/test.txt",  // Valid file path
            "/root/unauthorized.txt"        // Unauthorized path
        };

        for (String path : testPaths) {
            System.out.println("\\nTesting path: " + path);
            boolean result = copyFileToTemp(path);
            System.out.println("Operation " + (result ? "succeeded" : "failed"));
        }
    }
}
