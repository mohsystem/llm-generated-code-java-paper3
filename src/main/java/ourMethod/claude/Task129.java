package ourMethod.claude;

import java.io.*;
import java.nio.file.*;
import java.util.regex.Pattern;

public class Task129 {
    private static final String SERVER_FILE_PATH = "/secure/files/"; // Base directory for files
    private static final Pattern VALID_FILENAME = Pattern.compile("^[a-zA-Z0-9_.-]+$");
    
    public static byte[] retrieveFile(String fileName) throws IOException {
        // Input validation
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }
        
        // Validate filename format
        if (!VALID_FILENAME.matcher(fileName).matches()) {
            throw new IllegalArgumentException("Invalid filename format");
        }
        
        // Construct the full path and normalize it
        Path fullPath = Paths.get(SERVER_FILE_PATH, fileName).normalize();
        
        // Verify the path is within allowed directory
        if (!fullPath.startsWith(SERVER_FILE_PATH)) {
            throw new SecurityException("Access denied: Invalid path");
        }
        
        // Check if file exists
        if (!Files.exists(fullPath)) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        
        // Read file securely using NIO
        return Files.readAllBytes(fullPath);
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test.txt",
            "../secret.txt",  // should fail
            "file.doc",
            "malicious/../file",  // should fail
            "normal_file.pdf"
        };
        
        for (String file : testFiles) {
            try {
                byte[] content = retrieveFile(file);
                System.out.println("Successfully retrieved: " + file);
                // Process content here
            } catch (Exception e) {
                System.out.println("Error retrieving " + file + ": " + e.getMessage());
            }
        }
    }
}
