package Vanilla.claude;

import java.io.*;
import java.util.regex.*;

public class Task100 {
    public static String findPattern(String pattern, String filename) {
        StringBuilder result = new StringBuilder();
        try {
            Pattern regexPattern = Pattern.compile(pattern);
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = regexPattern.matcher(line);
                while (matcher.find()) {
                    result.append(matcher.group()).append("\\n");
                }
            }
            reader.close();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"\\\\b\\\\w+@\\\\w+\\\\.\\\\w+\\\\b", "test.txt"},  // Find email addresses
            {"\\\\d{3}-\\\\d{3}-\\\\d{4}", "contacts.txt"}, // Find phone numbers
            {"\\\\b[A-Z][a-z]*\\\\b", "names.txt"},       // Find capitalized words
            {"\\\\b\\\\d+\\\\.\\\\d{2}\\\\b", "prices.txt"},    // Find prices
            {"https?://\\\\S+", "urls.txt"}             // Find URLs
        };
        
        for (String[] testCase : testCases) {
            System.out.println("Pattern: " + testCase[0]);
            System.out.println("File: " + testCase[1]);
            System.out.println("Results:");
            System.out.println(findPattern(testCase[0], testCase[1]));
            System.out.println("------------------------");
        }
    }
}
