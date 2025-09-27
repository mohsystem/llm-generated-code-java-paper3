package ourMethod.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task94 {
    public static void main(String[] args) {
        String filename = "records.txt";
        List<Record> records = readRecords(filename);
        if (records != null) {
            sortRecords(records);
            printRecords(records);
        }
    }

    public static List<Record> readRecords(String filename) {
        List<Record> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    records.add(new Record(parts[0].trim(), parts[1].trim()));
                } else {
                    System.out.println("Skipping invalid record: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
        return records;
    }

    public static void sortRecords(List<Record> records) {
        Collections.sort(records, Comparator.comparing(Record::getKey));
    }

    public static void printRecords(List<Record> records) {
        for (Record record : records) {
            System.out.println(record.getKey() + "=" + record.getValue());
        }
    }

    public static class Record {
        private String key;
        private String value;

        public Record(String key, String value) {
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