package Vanilla.claude;

import java.io.*;
import java.util.*;

class Task93 {
    public static List<Map.Entry<String, String>> sortKeyValueFile(String filename) {
        Map<String, String> records = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    records.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, String>> sortedRecords = new ArrayList<>(records.entrySet());
        Collections.sort(sortedRecords, Map.Entry.comparingByKey());
        
        return sortedRecords;
    }

    public static void main(String[] args) {
        // Create test file
        try (PrintWriter writer = new PrintWriter("test.txt")) {
            writer.println("banana: yellow fruit");
            writer.println("apple: red fruit");
            writer.println("dog: pet animal");
            writer.println("cat: feline pet");
            writer.println("zebra: striped animal");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test cases
        List<Map.Entry<String, String>> result = sortKeyValueFile("test.txt");
        for (Map.Entry<String, String> entry : result) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
