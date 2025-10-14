package CoT.openai;
import java.io.*;
import java.util.*;

public class Task93 {

    public static Map<String, String> readAndSortFile(String filename) {
        Map<String, String> map = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    map.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        List<String> testFiles = Arrays.asList("file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt");
        for (String file : testFiles) {
            System.out.println("Contents of " + file + ":");
            Map<String, String> sortedMap = readAndSortFile(file);
            sortedMap.forEach((k, v) -> System.out.println(k + "=" + v));
            System.out.println();
        }
    }
}