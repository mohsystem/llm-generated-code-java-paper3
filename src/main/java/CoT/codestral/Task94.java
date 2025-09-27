package CoT.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Task94 {
    public static void main(String[] args) {
        try {
            System.out.println(sortRecords("test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> sortRecords(String filename) throws IOException {
        Map<String, String> records = new TreeMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                records.put(parts[0].trim(), parts[1].trim());
            }
        }

        br.close();
        return records;
    }
}