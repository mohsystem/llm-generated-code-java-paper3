package ZeroShot.claude;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task70 {
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        
        try {
            // Normalize and validate path
            Path normalizedPath = Paths.get(filePath).normalize();
            File file = normalizedPath.toFile();
            
            // Basic security checks
            if(!file.exists()) {
                return "File does not exist";
            }
            if(!file.canRead()) {
                return "File cannot be read";
            }
            
            // Read file using buffered reader
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\\n");
                }
            }
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        } catch (SecurityException e) {
            return "Security error: " + e.getMessage();
        }
        
        return content.toString();
    }

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Please provide file path as argument");
            return;
        }

        // Test cases
        String[] testFiles = {
            args[0],                    // User provided path
            "test1.txt",               // Normal file
            "../test2.txt",            // Parent directory access
            "nonexistent.txt",         // Non-existent file
            "/etc/passwd"              // System file access attempt
        };

        for(String filePath : testFiles) {
            System.out.println("Reading file: " + filePath);
            System.out.println(readFile(filePath));
            System.out.println("------------------------");
        }
    }
}
