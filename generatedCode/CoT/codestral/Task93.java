package CoT.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Task93 {
    public static Map<String, String> readAndSortFile(String fileName) throws IOException {
        Map<String, String> records = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                records.put(parts[0], parts[1]);
            }
        }
        reader.close();
        return records;
    }

    public static void main(String[] args) {
        try {
            Map<String, String> sortedRecords = readAndSortFile("records.txt");
            for (Map.Entry<String, String> entry : sortedRecords.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}