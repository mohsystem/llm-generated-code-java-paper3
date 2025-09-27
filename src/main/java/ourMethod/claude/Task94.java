package ourMethod.claude;

import java.io.*;
import java.util.*;

public class Task94 {
    public static List<Map.Entry<String, String>> readAndSortRecords(String filename) {
        // Using LinkedHashMap to maintain insertion order
        Map<String, String> records = new LinkedHashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    records.put(parts[0].trim(), parts[1].trim());
                }
            }
            
            // Convert to list for sorting
            List<Map.Entry<String, String>> sortedRecords = new ArrayList<>(records.entrySet());
            Collections.sort(sortedRecords, Map.Entry.comparingByKey());
            return sortedRecords;
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.txt", // Normal case with multiple records
            "test2.txt", // Empty file
            "test3.txt", // File with single record
            "test4.txt", // File with duplicate keys
            "test5.txt"  // File with invalid format
        };
        
        for (String testFile : testFiles) {
            System.out.println("Testing file: " + testFile);
            List<Map.Entry<String, String>> sorted = readAndSortRecords(testFile);
            for (Map.Entry<String, String> entry : sorted) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
            System.out.println();
        }
    }
}
