package ourMethod.claude;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task39 {
    private static final String BASE_DIRECTORY = System.getProperty("user.dir");

    public static String displayFileContents(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Error: Filename cannot be null or empty";
        }

        // Sanitize and validate the filename
        String sanitized = filename.trim();

        // Reject path traversal attempts
        if (sanitized.contains("..") || sanitized.contains("/") || sanitized.contains("\\")) {
            return "Error: Invalid filename - path traversal not allowed";
        }

        try {
            Path basePath = Paths.get(BASE_DIRECTORY).toRealPath();
            Path filePath = basePath.resolve(sanitized).normalize();

            // Ensure the resolved path is within the base directory
            if (!filePath.startsWith(basePath)) {
                return "Error: Access denied - file outside allowed directory";
            }

            // Check if file exists and is a regular file
            if (!Files.exists(filePath)) {
                return "Error: File does not exist";
            }

            if (!Files.isRegularFile(filePath)) {
                return "Error: Not a regular file";
            }

            // Read file contents safely
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }

            return content.toString();

        } catch (IOException e) {
            return "Error: Unable to read file - " + e.getMessage();
        } catch (SecurityException e) {
            return "Error: Security violation - " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {"test1.txt", "test2.txt", "../etc/passwd", "test/file.txt", ""};

        System.out.println("=== File Content Display Program ===\n");

        for (String testFile : testFiles) {
            System.out.println("Attempting to read: '" + testFile + "'");
            String result = displayFileContents(testFile);
            System.out.println(result);
            System.out.println("---");
        }

        // Interactive mode
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter filename to display (or 'quit' to exit): ");
        String userInput = scanner.nextLine();

        if (!userInput.equalsIgnoreCase("quit")) {
            String result = displayFileContents(userInput);
            System.out.println("\nFile contents:\n" + result);
        }

        scanner.close();
    }
}
