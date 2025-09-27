package Vanilla.claude;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.csv", // Simple CSV with numbers
            "test2.csv", // CSV with text
            "test3.csv", // CSV with mixed data
            "test4.csv", // Empty CSV
            "test5.csv"  // CSV with quoted strings
        };

        for (String file : testFiles) {
            System.out.println("Processing " + file + ":");
            List<List<String>> data = parseCSV(file);
            for (List<String> row : data) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
