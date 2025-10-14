package ZeroShot.openai;
import java.io.*;
import java.util.*;

public class Task93 {
    public static Map<String, String> readAndSortFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        TreeMap<String, String> sortedRecords = new TreeMap<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] keyValue = line.split("=", 2);
            if (keyValue.length == 2) {
                sortedRecords.put(keyValue[0].trim(), keyValue[1].trim());
            }
        }
        reader.close();
        return sortedRecords;
    }

    public static void main(String[] args) {
        try {
            Map<String, String> result = readAndSortFile("test.txt");
            for (Map.Entry<String, String> entry : result.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}