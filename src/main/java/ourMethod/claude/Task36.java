package ourMethod.claude;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Task36 {
    public static String readFile(String filePath) throws IOException {
        // Validate file path
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        // Convert to canonical path to resolve any .. or . in path
        File file = new File(filePath);
        String canonicalPath = file.getCanonicalPath();

        // Verify file exists and is a regular file
        if (!Files.exists(Paths.get(canonicalPath))) {
            throw new FileNotFoundException("File does not exist: " + filePath);
        }
        if (!Files.isRegularFile(Paths.get(canonicalPath))) {
            throw new IllegalArgumentException("Path is not a regular file: " + filePath);
        }

        // Read file contents using secure method
        return Files.readString(Paths.get(canonicalPath));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Test cases
        String[] testFiles = {
            "test1.txt",
            "test2.txt", 
            "test3.txt",
            "test4.txt",
            "test5.txt"
        };

        // Run test cases
        for (String testFile : testFiles) {
            try {
                System.out.println("\\nReading file: " + testFile);
                String content = readFile(testFile);
                System.out.println("Content:");
                System.out.println(content);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        // Interactive mode
        try {
            System.out.print("\\nEnter file path to read: ");
            String filePath = scanner.nextLine();
            String content = readFile(filePath);
            System.out.println("File contents:");
            System.out.println(content);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
