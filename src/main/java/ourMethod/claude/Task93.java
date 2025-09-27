package ourMethod.claude;

import java.io.*;
import java.util.*;

public class Task93 {
    public static Map<String, String> readAndSortKeyValueFile(String filename) {
        Map<String, String> sortedMap = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    if (parts.length == 2) {
                        String key = parts[0].trim();
                        String value = parts[1].trim();
                        if (!key.isEmpty()) {
                            sortedMap.put(key, value);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Create test file
            try (PrintWriter writer = new PrintWriter("test.txt")) {
                writer.println("b=value2");
                writer.println("a=value1"); 
                writer.println("d=value4");
                writer.println("c=value3");
                writer.println("e=value5");
            }

            Map<String, String> result = readAndSortKeyValueFile("test.txt");
            for (Map.Entry<String, String> entry : result.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
            
        } catch (IOException e) {
            System.err.println("Error in test cases: " + e.getMessage());
        }
    }
}
