package ZeroShot.claude;

import java.io.*;
import java.util.*;

public class Task93 {
    public static List<Map.Entry<String, String>> readAndSortRecords(String filename) {
        Map<String, String> records = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    records.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
        
        List<Map.Entry<String, String>> sortedRecords = new ArrayList<>(records.entrySet());
        Collections.sort(sortedRecords, Map.Entry.comparingByKey());
        return sortedRecords;
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Create test files
            String[] testFiles = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
            String[][] testContents = {
                {"key1:value1", "key2:value2", "key3:value3"},
                {"b:2", "a:1", "c:3"},
                {"name:John", "age:25", "city:NY"},
                {"1:one", "2:two", "3:three"},
                {"z:last", "x:middle", "y:end"}
            };

            for (int i = 0; i < testFiles.length; i++) {
                try (PrintWriter writer = new PrintWriter(testFiles[i])) {
                    for (String line : testContents[i]) {
                        writer.println(line);
                    }
                }

                System.out.println("Test case " + (i + 1) + ":");
                List<Map.Entry<String, String>> sorted = readAndSortRecords(testFiles[i]);
                for (Map.Entry<String, String> entry : sorted) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                System.out.println();

                // Clean up test files
                new File(testFiles[i]).delete();
            }
        } catch (IOException e) {
            System.err.println("Error in test cases: " + e.getMessage());
        }
    }
}
