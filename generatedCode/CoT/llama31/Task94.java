package CoT.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task94 {
    public static void main(String[] args) {
        String[] testFiles = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
        for (String file : testFiles) {
            sortKeyValueFile(file);
        }
    }

    public static void sortKeyValueFile(String fileName) {
        List<KeyValue> keyValueList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    keyValueList.add(new KeyValue(parts[0], parts[1]));
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort the list
        Collections.sort(keyValueList, Comparator.comparing(KeyValue::getKey));

        // Write the sorted list to a new file
        String outputFileName = "sorted_" + fileName;
        try (FileWriter writer = new FileWriter(outputFileName)) {
            for (KeyValue keyValue : keyValueList) {
                writer.write(keyValue.getKey() + "=" + keyValue.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    static class KeyValue {
        private String key;
        private String value;

        public KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}