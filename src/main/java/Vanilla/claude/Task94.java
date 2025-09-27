package Vanilla.claude;

import java.io.*;
import java.util.*;

public class Task94 {
    public static List<Map.Entry<String, String>> sortKeyValueFile(String filename) {
        Map<String, String> map = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    map.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<Map.Entry<String, String>> sortedList = new ArrayList<>(map.entrySet());
        Collections.sort(sortedList, (a, b) -> a.getKey().compareTo(b.getKey()));
        return sortedList;
    }

    public static void main(String[] args) {
        // Create test files
        String[] testFiles = new String[]{"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
        String[][] testData = {
            {"key1:value1", "key2:value2", "key3:value3"},
            {"banana:yellow", "apple:red", "cherry:red"},
            {"z:26", "y:25", "x:24"},
            {"name:john", "age:30", "city:nyc"},
            {"1:one", "2:two", "3:three"}
        };

        for(int i = 0; i < testFiles.length; i++) {
            try (PrintWriter writer = new PrintWriter(testFiles[i])) {
                for(String line : testData[i]) {
                    writer.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Test case " + (i+1) + ":");
            List<Map.Entry<String, String>> result = sortKeyValueFile(testFiles[i]);
            for(Map.Entry<String, String> entry : result) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
            System.out.println();
        }
    }
}
