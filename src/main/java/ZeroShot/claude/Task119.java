package ZeroShot.claude;

import java.io.*;
import java.util.*;

public class Task119 {
    public static List<List<String>> parseCSV(String filename) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return records;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.csv", // Simple CSV with numbers
            "test2.csv", // CSV with text data
            "test3.csv", // CSV with mixed data
            "test4.csv", // Empty CSV
            "test5.csv"  // CSV with special characters
        };

        for (String file : testFiles) {
            System.out.println("Processing " + file + ":");
            List<List<String>> data = parseCSV(file);
            for (List<String> record : data) {
                System.out.println(record);
            }
            System.out.println();
        }
    }
}
