package ZeroShot.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task93 {
    public static void main(String[] args) {
        String[] testFiles = {"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"};
        for (String file : testFiles) {
            sortKeyValueFile(file);
        }
    }

    public static void sortKeyValueFile(String fileName) {
        List<KeyValue> keyValueList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    keyValueList.add(new KeyValue(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        Collections.sort(keyValueList);

        System.out.println("Sorted Key-Value Pairs for " + fileName + ":");
        for (KeyValue kv : keyValueList) {
            System.out.println(kv.getKey() + "=" + kv.getValue());
        }
    }

    static class KeyValue implements Comparable<KeyValue> {
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

        @Override
        public int compareTo(KeyValue other) {
            return this.key.compareTo(other.key);
        }
    }
}