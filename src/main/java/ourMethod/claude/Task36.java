package ourMethod.claude;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task36 {
    private static final Path BASE_DIRECTORY;
    
    static {
        try {
            BASE_DIRECTORY = Paths.get(System.getProperty("user.dir")).toRealPath();
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Failed to initialize base directory: " + e.getMessage());
        }
    }
    
    public static String readFileContents(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            return "Error: File path cannot be null or empty";
        }
        
        if (filePath.length() > 4096) {
            return "Error: File path too long";
        }
        
        try {
            Path requestedPath = BASE_DIRECTORY.resolve(filePath).normalize();
            
            if (!requestedPath.startsWith(BASE_DIRECTORY)) {
                return "Error: Access denied - path outside allowed directory";
            }
            
            if (!Files.exists(requestedPath)) {
                return "Error: File does not exist";
            }
            
            if (!Files.isRegularFile(requestedPath)) {
                return "Error: Path is not a regular file";
            }
            
            if (!Files.isReadable(requestedPath)) {
                return "Error: File is not readable";
            }
            
            long fileSize = Files.size(requestedPath);
            if (fileSize > 10_000_000) {
                return "Error: File too large (max 10MB)";
            }
            
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = Files.newBufferedReader(requestedPath, StandardCharsets.UTF_8)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append(System.lineSeparator());
                }
            }
            
            return content.toString();
            
        } catch (InvalidPathException e) {
            return "Error: Invalid file path";
        } catch (IOException e) {
            return "Error: Failed to read file - " + e.getClass().getSimpleName();
        } catch (SecurityException e) {
            return "Error: Security exception - access denied";
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Test Case 1 - Valid file:");
        try {
            Path testFile1 = Files.createTempFile(BASE_DIRECTORY, "test1_", ".txt");
            Files.write(testFile1, "Hello, World!".getBytes(StandardCharsets.UTF_8));
            System.out.println(readFileContents(testFile1.getFileName().toString()));
            Files.deleteIfExists(testFile1);
        } catch (IOException e) {
            System.out.println("Failed to create test file");
        }
        
        System.out.println("\\nTest Case 2 - Non-existent file:");
        System.out.println(readFileContents("nonexistent_file.txt"));
        
        System.out.println("\\nTest Case 3 - Path traversal attempt:");
        System.out.println(readFileContents("../../etc/passwd"));
        
        System.out.println("\\nTest Case 4 - Null input:");
        System.out.println(readFileContents(null));
        
        System.out.println("\\nTest Case 5 - Empty path:");
        System.out.println(readFileContents(""));
    }
}
