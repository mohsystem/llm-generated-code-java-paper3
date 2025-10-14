package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Task94 {

    public static Map<String, String> readAndSortFile(String fileName) {
        Map<String, String> sortedRecords = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    sortedRecords.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sortedRecords;
    }

    public static void main(String[] args) {
        String fileName = "input.txt";
        Map<String, String> sortedRecords = readAndSortFile(fileName);
        sortedRecords.forEach((key, value) -> System.out.println(key + "=" + value));
    }
}