package ourMethod.openai;
import java.io.*;
import java.util.*;

public class Task93 {
    public static Map<String, String> readAndSortKeyValueFile(String filePath) {
        Map<String, String> map = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length >= 2) {
                    map.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        for (String filePath : Arrays.asList("test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt")) {
            Map<String, String> sortedRecords = readAndSortKeyValueFile(filePath);
            sortedRecords.forEach((key, value) -> System.out.println(key + "=" + value));
        }
    }
}