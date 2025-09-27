package ourMethod.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task93 {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String outputFileName = "output.txt";
        List<KeyValue> keyValuePairs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    keyValuePairs.add(new KeyValue(parts[0], parts[1]));
                } else {
                    System.out.println("Ignoring invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        Collections.sort(keyValuePairs);

        try (FileWriter writer = new FileWriter(outputFileName)) {
            for (KeyValue pair : keyValuePairs) {
                writer.write(pair.getKey() + "=" + pair.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
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