package ourMethod.claude;

import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task119 {
    public static List<List<String>> parseCSV(String filePath) throws IOException {
        // Validate file path
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        
        // Validate file exists and is readable
        Path path = Paths.get(filePath);
        if (!Files.exists(path) || !Files.isReadable(path)) {
            throw new IOException("File does not exist or is not readable: " + filePath);
        }
        
        List<List<String>> records = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(Files.newInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    List<String> values = parseLine(line);
                    records.add(values);
                }
            }
        }
        return records;
    }
    
    private static List<String> parseLine(String line) {
        List<String> result = new ArrayList<>();
        if (line == null) {
            return result;
        }
        
        StringBuilder currentValue = new StringBuilder();
        boolean inQuotes = false;
        
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            
            if (currentChar == '"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    currentValue.append('"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (currentChar == ',' && !inQuotes) {
                result.add(currentValue.toString().trim());
                currentValue.setLength(0);
            } else {
                currentValue.append(currentChar);
            }
        }
        result.add(currentValue.toString().trim());
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        try {
            // Test case 1: Basic CSV file
            String csv1 = "test1.csv";
            Files.write(Paths.get(csv1), "a,b,c\\n1,2,3".getBytes());
            System.out.println("Test 1: " + parseCSV(csv1));
            
            // Test case 2: CSV with quoted values
            String csv2 = "test2.csv";
            Files.write(Paths.get(csv2), "\\"hello,world\\",test".getBytes());
            System.out.println("Test 2: " + parseCSV(csv2));
            
            // Test case 3: Empty file
            String csv3 = "test3.csv";
            Files.write(Paths.get(csv3), "".getBytes());
            System.out.println("Test 3: " + parseCSV(csv3));
            
            // Test case 4: File with empty lines
            String csv4 = "test4.csv";
            Files.write(Paths.get(csv4), "a,b\\n\\n1,2".getBytes());
            System.out.println("Test 4: " + parseCSV(csv4));
            
            // Test case 5: CSV with escaped quotes
            String csv5 = "test5.csv";
            Files.write(Paths.get(csv5), "\\"\\"\\"quoted\\"\\"\\",value".getBytes());
            System.out.println("Test 5: " + parseCSV(csv5));
            
        } catch (IOException e) {
            System.err.println("Error processing CSV files: " + e.getMessage());
        }
    }
}
