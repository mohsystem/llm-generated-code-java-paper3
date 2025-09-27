package CoT.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task93 {
    public static void main(String[] args) {
        String[] testFiles = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
        for (String file : testFiles) {
            sortKeyValueRecords(file);
        }
    }

    public static void sortKeyValueRecords(String fileName) {
        Map<String, String> keyValueMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    keyValueMap.put(parts[0], parts[1]);
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort the map
        Map<String, String> sortedMap = new TreeMap<>(keyValueMap);

        // Write the sorted map to a new file
        try (FileWriter fw = new FileWriter("sorted_" + fileName)) {
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                fw.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}