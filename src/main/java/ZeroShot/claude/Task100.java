package ZeroShot.claude;

import java.io.*;
import java.util.regex.*;

public class Task100 {
    public static String searchPattern(String pattern, String filename) {
        StringBuilder result = new StringBuilder();
        try {
            // Compile pattern securely
            Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            
            // Read file using try-with-resources
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                int lineNum = 1;
                while ((line = reader.readLine()) != null) {
                    Matcher matcher = regex.matcher(line);
                    while (matcher.find()) {
                        result.append(String.format("Line %d: %s%n", lineNum, matcher.group()));
                    }
                    lineNum++;
                }
            }
        } catch (PatternSyntaxException e) {
            return "Invalid regex pattern: " + e.getMessage();
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
        return result.length() > 0 ? result.toString() : "No matches found";
    }

    public static void main(String[] args) {
        // Test cases
        String[] patterns = {
            "\\\\b\\\\w+@\\\\w+\\\\.\\\\w+\\\\b",  // email pattern
            "\\\\b\\\\d{3}-\\\\d{3}-\\\\d{4}\\\\b", // phone number pattern
            "https?://\\\\S+", // URL pattern
            "\\\\b[A-Z][a-z]+\\\\b", // Capitalized word
            "[0-9]+" // Numbers
        };
        
        String[] files = {
            "sample1.txt",
            "sample2.txt",
            "sample3.txt",
            "sample4.txt",
            "sample5.txt"
        };
        
        for(int i = 0; i < 5; i++) {
            System.out.println("\\nTest Case " + (i+1) + ":");
            System.out.println("Pattern: " + patterns[i]);
            System.out.println("File: " + files[i]);
            System.out.println("Result:");
            System.out.println(searchPattern(patterns[i], files[i]));
        }
    }
}
