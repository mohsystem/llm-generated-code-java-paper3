package ZeroShot.claude;

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

            Path path = Paths.get(filePath).normalize().toAbsolutePath();
            File file = path.toFile();

            // Check if file exists and is a regular file
            if (!file.exists() || !file.isFile()) {
                return false;
            }

            // Check if we have permission to delete
            if (!file.canWrite()) {
                return false;
            }

            // Delete the file
            return Files.deleteIfExists(path);

        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testPaths = {
            "test1.txt",
            "nonexistent.txt",
            "../test2.txt",
            "",
            "directory/"
        };

        for (String path : testPaths) {
            boolean result = deleteFile(path);
            System.out.println("Deleting " + path + ": " + result);
        }
    }
}
