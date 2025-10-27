package CoT.claude;

import java.io.*;
import java.util.regex.*;

public class Task99 {
    public static String[] findMatchingLines(String filename) {
        StringBuilder matches = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            Pattern pattern = Pattern.compile("^\\\\d+.*\\\\.$");
            
            while ((line = reader.readLine()) != null) {
                if (pattern.matcher(line).matches()) {
                    matches.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return new String[0];
        }
        return matches.toString().split("\n");
    }

    public static void main(String[] args) {
        // Test cases with sample file content
        String[] testFiles = {
            "test1.txt", // Contains: "123 hello world."
            "test2.txt", // Contains: "456 testing."
            "test3.txt", // Contains: "abc 123." (shouldn't match)
            "test4.txt", // Contains: "789 test case."
            "test5.txt"  // Contains: "012 final test."
        };
        
        for (String file : testFiles) {
            System.out.println("Testing file: " + file);
            String[] matches = findMatchingLines(file);
            for (String match : matches) {
                System.out.println("Matched line: " + match);
            }
            System.out.println();
        }
    }
}
