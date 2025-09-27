package CoT.claude;

import java.io.*;
import java.util.*;

public class Task93 {
    public static Map<String, String> readAndSortFile(String filename) {
        Map<String, String> records = new TreeMap<>(); // Using TreeMap for automatic sorting by key
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = line = br.readLine()) != null) {
                if(line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    if(parts.length == 2) {
                        records.put(parts[0].trim(), parts[1].trim());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return records;
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Create test file
            try (PrintWriter writer = new PrintWriter("test.txt")) {
                writer.println("name=John");
                writer.println("age=25");
                writer.println("city=NewYork");
                writer.println("country=USA");
                writer.println("job=Engineer");
            }

            Map<String, String> sortedRecords = readAndSortFile("test.txt");
            for (Map.Entry<String, String> entry : sortedRecords.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
            
        } catch (IOException e) {
            System.err.println("Error in test cases: " + e.getMessage());
        }
    }
}
