package CoT.claude;

import java.io.*;
import java.nio.file.*;

public class Task36 {
    public static String readFile(String filename) {
        StringBuilder content = new StringBuilder();
        try {
            // Using NIO for secure file reading
            Path path = Paths.get(filename).normalize();
            // Verify the path is within allowed directory
            if (!path.toFile().getCanonicalPath().startsWith(System.getProperty("user.dir"))) {
                return "Access denied - Cannot access files outside current directory";
            }
            // Check if file exists and is readable
            if (!Files.exists(path) || !Files.isReadable(path)) {
                return "File does not exist or is not readable";
            }
            // Read file content securely using NIO
            content.append(Files.readString(path));
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        } catch (SecurityException e) {
            return "Security error: " + e.getMessage();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.txt",
            "nonexistent.txt",
            "../test.txt",  // attempting to access parent directory
            "test2.txt",
            "test3.txt"
        };

        for (String file : testFiles) {
            System.out.println("Reading file: " + file);
            System.out.println(readFile(file));
            System.out.println("------------------------");
        }
    }
}
