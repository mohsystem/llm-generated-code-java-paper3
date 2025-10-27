package CoT.claude;

import java.io.*;
import java.util.regex.*;

public class Task100 {
    public static String searchPattern(String regexPattern, String fileName) {
        StringBuilder result = new StringBuilder();
        
        try {
            // Validate and compile regex pattern
            if (regexPattern == null || regexPattern.trim().isEmpty()) {
                return "Invalid regex pattern";
            }
            Pattern pattern = Pattern.compile(regexPattern);
            
            // Validate file name and read file
            if (fileName == null || fileName.trim().isEmpty()) {
                return "Invalid file name";
            }
            
            File file = new File(fileName);
            if (!file.exists() || !file.isFile() || !file.canRead()) {
                return "File does not exist or cannot be read";
            }
            
            // Read file content safely
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        result.append("Match found: ").append(matcher.group()).append("\n");
                    }
                }
            }
            
            return result.length() > 0 ? result.toString() : "No matches found";
            
        } catch (PatternSyntaxException e) {
            return "Invalid regex pattern syntax: " + e.getMessage();
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1:");
        System.out.println(searchPattern("[0-9]+", "test.txt"));
        
        System.out.println("\\nTest Case 2:");
        System.out.println(searchPattern("[a-zA-Z]+", "sample.txt"));
        
        System.out.println("\\nTest Case 3:");
        System.out.println(searchPattern(null, "test.txt"));
        
        System.out.println("\\nTest Case 4:");
        System.out.println(searchPattern("[0-9]+", "nonexistent.txt"));
        
        System.out.println("\\nTest Case 5:");
        System.out.println(searchPattern("[", "test.txt"));
    }
}
