package Vanilla.openai;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task93 {

    public static Map<String, String> readAndSortFile(String filename) {
        Map<String, String> records = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    records.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static void main(String[] args) {
        List<String> filenames = new ArrayList<>();
        filenames.add("file1.txt");
        filenames.add("file2.txt");
        filenames.add("file3.txt");
        filenames.add("file4.txt");
        filenames.add("file5.txt");

        for (String filename : filenames) {
            Map<String, String> sortedRecords = readAndSortFile(filename);
            System.out.println("Sorted records for " + filename + ": " + sortedRecords);
        }
    }
}