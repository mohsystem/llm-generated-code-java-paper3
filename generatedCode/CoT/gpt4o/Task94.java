package CoT.gpt4o;
import java.io.*;
import java.util.*;

public class Task94 {
    public static Map<String, String> readAndSortFile(String filename) {
        Map<String, String> map = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] keyValue = line.split("=", 2);
                if (keyValue.length == 2) {
                    map.put(keyValue[0].trim(), keyValue[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String, String> sortedRecords = readAndSortFile("records.txt");
        for (Map.Entry<String, String> entry : sortedRecords.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}