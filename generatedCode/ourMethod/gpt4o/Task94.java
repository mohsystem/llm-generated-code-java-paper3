package ourMethod.openai;
import java.io.*;
import java.util.*;

public class Task94 {

    public static List<String> readAndSortFile(String filePath) {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    records.add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(records);
        return records;
    }

    public static void main(String[] args) {
        List<String> sortedRecords = readAndSortFile("records.txt");
        for (String record : sortedRecords) {
            System.out.println(record);
        }
    }
}