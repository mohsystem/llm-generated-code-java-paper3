package ourMethod.claude;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task65 {
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB limit
    private static final int MAX_FILENAME_LENGTH = 255;

    public static String readFileSecurely(String filename, String baseDirectory) {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }

        if (filename.length() > MAX_FILENAME_LENGTH) {
            throw new IllegalArgumentException("Filename exceeds maximum length");
        }

        // Validate filename characters - reject control characters and path traversal
        if (!isValidFilename(filename)) {
            throw new IllegalArgumentException("Invalid filename format");
        }

        try {
            Path basePath = Paths.get(baseDirectory).toRealPath();
            Path requestedPath = basePath.resolve(filename).normalize();

            // Ensure the resolved path is within the base directory
            if (!requestedPath.startsWith(basePath)) {
                throw new SecurityException("Path traversal attempt detected");
            }

            // Get real path to resolve symlinks
            Path realPath = requestedPath.toRealPath();

            // Verify real path still within base directory after symlink resolution
            if (!realPath.startsWith(basePath)) {
                throw new SecurityException("Symlink points outside base directory");
            }

            // Check if path is a regular file
            if (!Files.isRegularFile(realPath)) {
                throw new IllegalArgumentException("Path is not a regular file");
            }

            // Check file is readable
            if (!Files.isReadable(realPath)) {
                throw new SecurityException("File is not readable");
            }

            // Check file size
            long fileSize = Files.size(realPath);
            if (fileSize > MAX_FILE_SIZE) {
                throw new IllegalArgumentException("File size exceeds maximum allowed size");
            }

            // Read file content
            byte[] fileBytes = Files.readAllBytes(realPath);
            return new String(fileBytes, StandardCharsets.UTF_8);

        } catch (InvalidPathException e) {
            throw new IllegalArgumentException("Invalid path format: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + e.getMessage());
        }
    }

    private static boolean isValidFilename(String filename) {
        // reject embedded NUL and parent traversal
        if (filename.indexOf('\0') >= 0 || filename.contains("..")) {
            return false;
        }

        for (char c : filename.toCharArray()) {
            if (Character.isISOControl(c)) {
                return false;
            }
        }

        // Reject absolute paths
        if (filename.startsWith("/") || filename.startsWith("\\")
                || (filename.length() > 1 && filename.charAt(1) == ':')) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String baseDir = System.getProperty("user.dir") + "/testfiles";

        // Create test directory and files
        try {
            Files.createDirectories(Paths.get(baseDir));

            // Test case 1: Valid file
            Path testFile1 = Paths.get(baseDir, "test1.txt");
            Files.write(testFile1, "Hello, World!".getBytes(StandardCharsets.UTF_8));

            // Test case 2: Another valid file
            Path testFile2 = Paths.get(baseDir, "test2.txt");
            Files.write(testFile2, "Test content 2".getBytes(StandardCharsets.UTF_8));

            // Test case 3: File with subdirectory
            Files.createDirectories(Paths.get(baseDir, "subdir"));
            Path testFile3 = Paths.get(baseDir, "subdir", "test3.txt");
            Files.write(testFile3, "Subdirectory content".getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            System.err.println("Setup error: " + e.getMessage());
            return;
        }

        // Test case 1: Valid file
        System.out.println("Test 1 - Valid file:");
        try {
            String content = readFileSecurely("test1.txt", baseDir);
            System.out.println("Success: " + content);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test case 2: Another valid file
        System.out.println("Test 2 - Another valid file:");
        try {
            String content = readFileSecurely("test2.txt", baseDir);
            System.out.println("Success: " + content);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test case 3: Valid file in subdirectory
        System.out.println("Test 3 - File in subdirectory:");
        try {
            String content = readFileSecurely("subdir/test3.txt", baseDir);
            System.out.println("Success: " + content);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test case 4: Path traversal attempt
        System.out.println("Test 4 - Path traversal attempt:");
        try {
            String content = readFileSecurely("../../../etc/passwd", baseDir);
            System.out.println("Success: " + content);
        } catch (Exception e) {
            System.err.println("Error (expected): " + e.getMessage());
        }

        // Test case 5: Non-existent file
        System.out.println("Test 5 - Non-existent file:");
        try {
            String content = readFileSecurely("nonexistent.txt", baseDir);
            System.out.println("Success: " + content);
        } catch (Exception e) {
            System.err.println("Error (expected): " + e.getMessage());
        }
    }
}
