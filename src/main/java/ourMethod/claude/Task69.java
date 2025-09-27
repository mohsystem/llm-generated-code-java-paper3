package ourMethod.claude;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task69 {
    public static boolean deleteFile(String filePath) {
        try {
            if (filePath == null || filePath.trim().isEmpty()) {
                throw new IllegalArgumentException("File path cannot be null or empty");
            }

            // Convert to canonical path to handle any directory traversal attempts
            Path path = Paths.get(filePath).toRealPath();
            File file = path.toFile();

            // Verify file exists and is actually a file
            if (!file.exists()) {
                System.out.println("File does not exist: " + path);
                return false;
            }
            if (!file.isFile()) {
                System.out.println("Path is not a file: " + path);
                return false;
            }

            // Delete the file
            Files.delete(path);
            return true;
        } catch (SecurityException e) {
            System.out.println("Security error: No permission to delete file");
            return false;
        } catch (Exception e) {
            System.out.println("Error deleting file: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testPaths = {
            "test.txt",                    // Normal file
            "",                            // Empty path
            null,                          // Null path
            "../test.txt",                 // Path traversal attempt
            "nonexistent.txt",             // Non-existent file
            "C:\\\\Windows\\\\System32\\\\test", // System directory attempt
            "test/directory"               // Directory instead of file
        };

        for (String path : testPaths) {
            System.out.println("\\nTesting path: " + path);
            boolean result = deleteFile(path);
            System.out.println("Result: " + result);
        }
    }
}
