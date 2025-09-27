package ZeroShot.claude;

import java.io.*;
import java.util.*;

public class Task94 {
    public static List<Map.Entry<String, String>> readAndSortFile(String filename) {
        List<Map.Entry<String, String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    records.add(new AbstractMap.SimpleEntry<>(parts[0].trim(), parts[1].trim()));
                }
            }
            Collections.sort(records, Map.Entry.comparingByKey());
            return records;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // Test cases
        // Create a test file
        try {
            FileWriter writer = new FileWriter("test.txt");
            writer.write("banana: yellow fruit\\n");
            writer.write("apple: red fruit\\n");
            writer.write("zebra: striped animal\\n");
            writer.write("cat: domestic pet\\n");
            writer.write("dog: loyal animal\\n");
            writer.close();

            List<Map.Entry<String, String>> sortedRecords = readAndSortFile("test.txt");
            for (Map.Entry<String, String> record : sortedRecords) {
                System.out.println(record.getKey() + ": " + record.getValue());
            }

        } catch (IOException e) {
            System.err.println("Error creating test file: " + e.getMessage());
        }
    }
}
