package ourMethodv2.gpt4o;
import java.io.*;
import java.util.*;

public class Task93 {

    public static Map<String, String> readAndSortFile(String fileName) {
        Map<String, String> records = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split("=", 2);
                if (keyValue.length == 2) {
                    records.put(keyValue[0].trim(), keyValue[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static void main(String[] args) {
        Map<String, String> sortedRecords = readAndSortFile("records.txt");
        for (Map.Entry<String, String> entry : sortedRecords.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}