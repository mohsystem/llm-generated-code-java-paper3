package CoT.claude;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task69 {
    public static boolean deleteFile(String filePath) {
        try {
            if (filePath == null || filePath.trim().isEmpty()) {
                return false;
            }
            
            Path path = Paths.get(filePath).normalize();
            File file = path.toFile();
            
            // Check if file exists and is actually a file
            if (!file.exists() || !file.isFile()) {
                return false;
            }
            
            // Check if we have permissions to delete
            if (!file.canWrite()) {
                return false;
            }
            
            // Securely delete the file
            return Files.deleteIfExists(path);
            
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testPaths = {
            "test1.txt",
            "folder/test2.txt",
            "", // empty path
            null, // null path
            "nonexistent.txt"
        };

        for(String path : testPaths) {
            boolean result = deleteFile(path);
            System.out.println("Deleting file: " + path + " - Result: " + result);
        }
    }
}
