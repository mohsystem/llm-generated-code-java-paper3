package CoT.claude;

import java.io.*;
import java.util.*;

public class Task94 {
    public static Map<String, String> readAndSortFile(String filename) {
        Map<String, String> sortedMap = new TreeMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    sortedMap.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return sortedMap;
    }

    public static void main(String[] args) {
        // Test cases with sample file contents
        String[] testFiles = {
            "test1.txt", // contains: name:John\
age:25\
city:NewYork
            "test2.txt", // contains: color:blue\
size:large\
price:100
            "test3.txt", // contains: country:USA\
state:CA\
zip:90210
            "test4.txt", // contains: fruit:apple\
vegetable:carrot\
meat:chicken
            "test5.txt"  // contains: language:Java\
version:17\
status:stable
        };

        for (String testFile : testFiles) {
            System.out.println("Reading and sorting file: " + testFile);
            Map<String, String> result = readAndSortFile(testFile);
            for (Map.Entry<String, String> entry : result.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
        }
    }
}
