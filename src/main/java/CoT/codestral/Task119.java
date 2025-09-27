package CoT.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task119 {
    public static List<List<String>> parseCSV(String filename) throws IOException {
        List<List<String>> records = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            List<String> record = new ArrayList<>();
            for (String value : values) {
                record.add(value.trim());
            }
            records.add(record);
        }
        br.close();
        return records;
    }

    public static void main(String[] args) throws IOException {
        List<List<String>> records = parseCSV("example.csv");
        for (List<String> record : records) {
            System.out.println(record);
        }
    }
}