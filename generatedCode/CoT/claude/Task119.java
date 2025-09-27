package CoT.claude;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Task119 {
    public static List<List<String>> parseCSV(String filePath) {
        List<List<String>> records = new ArrayList<>();
        
        // Validate file path
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        
        // Verify file exists and has .csv extension
        Path path = Paths.get(filePath);
        if (!Files.exists(path) || !filePath.toLowerCase().endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid CSV file path");
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;
                
                // Split by comma while handling quoted values
                List<String> values = new ArrayList<>();
                boolean inQuotes = false;
                StringBuilder currentValue = new StringBuilder();
                
                for (char c : line.toCharArray()) {
                    if (c == '"') {
                        inQuotes = !inQuotes;
                    } else if (c == ',' && !inQuotes) {
                        values.add(currentValue.toString().trim());
                        currentValue = new StringBuilder();
                    } else {
                        currentValue.append(c);
                    }
                }
                values.add(currentValue.toString().trim());
                records.add(values);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + e.getMessage());
        }
        
        return records;
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Test case 1: Normal CSV file
            String csvContent1 = "name,age,city\\nJohn,25,New York\\nJane,30,Boston";
            Files.write(Paths.get("test1.csv"), csvContent1.getBytes());
            System.out.println("Test 1: " + parseCSV("test1.csv"));

            // Test case 2: CSV with quoted values
            String csvContent2 = "\\"name,with,comma\\",value1,value2\\ndata1,data2,data3";
            Files.write(Paths.get("test2.csv"), csvContent2.getBytes());
            System.out.println("Test 2: " + parseCSV("test2.csv"));

            // Test case 3: Empty lines in CSV
            String csvContent3 = "header1,header2\\n\\nvalue1,value2\\n\\nvalue3,value4";
            Files.write(Paths.get("test3.csv"), csvContent3.getBytes());
            System.out.println("Test 3: " + parseCSV("test3.csv"));

            // Test case 4: Single column CSV
            String csvContent4 = "value1\\nvalue2\\nvalue3";
            Files.write(Paths.get("test4.csv"), csvContent4.getBytes());
            System.out.println("Test 4: " + parseCSV("test4.csv"));

            // Test case 5: Invalid file path
            try {
                parseCSV("nonexistent.csv");
            } catch (IllegalArgumentException e) {
                System.out.println("Test 5: Caught expected exception - " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error in test cases: " + e.getMessage());
        }
    }
}
