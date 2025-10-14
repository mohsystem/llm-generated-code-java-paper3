package ZeroShot.openai;
import java.io.*;
import java.util.*;

public class Task94 {
    public static Map<String, String> readAndSortFile(String filename) {
        Map<String, String> records = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=", 2);
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
        List<String> testFiles = Arrays.asList("test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt");
        for (String testFile : testFiles) {
            System.out.println("Sorted records from " + testFile + ": " + readAndSortFile(testFile));
        }
    }
}