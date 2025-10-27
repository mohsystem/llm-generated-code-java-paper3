package ourMethod.claude;

import java.io.*;
import java.util.regex.*;

public class Task99 {
    public static String findNumberDotLines(String filename) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("^\\\\d+.*\\\\.$");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (pattern.matcher(line).matches()) {
                    result.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.txt",
            "test2.txt", 
            "test3.txt",
            "test4.txt",
            "test5.txt"
        };
        
        for(String file : testFiles) {
            System.out.println("Testing file: " + file);
            System.out.println(findNumberDotLines(file));
            System.out.println("-------------------");
        }
    }
}
