package ZeroShot.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task94 {

    public static List<Map.Entry<String, String>> sortRecords(String filePath) throws IOException {
        List<Map.Entry<String, String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+", 2); // Split into key-value
                if (parts.length == 2) {
                    records.add(new HashMap.Entry<String, String>() {
                        @Override
                        public String getKey() {
                            return parts[0];
                        }

                        @Override
                        public String getValue() {
                            return parts[1];
                        }

                        @Override
                        public String setValue(String value) {
                            return null; // Immutable entry
                        }
                    });
                }
            }
        }
        Collections.sort(records, Comparator.comparing(Map.Entry::getKey));
        return records;

    }

    public static void main(String[] args) throws IOException {
        List<Map.Entry<String, String>> result1 = sortRecords("test1.txt");
        System.out.println(result1);
        List<Map.Entry<String, String>> result2 = sortRecords("test2.txt");
        System.out.println(result2);
        List<Map.Entry<String, String>> result3 = sortRecords("test3.txt");
        System.out.println(result3);
        List<Map.Entry<String, String>> result4 = sortRecords("test4.txt");
        System.out.println(result4);
        List<Map.Entry<String, String>> result5 = sortRecords("test5.txt");
        System.out.println(result5);


    }
}