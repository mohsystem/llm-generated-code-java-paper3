package CoT.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task119 {

    public static List<List<String>> parseCSV(String filePath) throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }

    public static void main(String[] args) throws IOException {
        String filePath1 = "test1.csv"; // Create these files for testing
        String filePath2 = "test2.csv";
        String filePath3 = "test3.csv";
        String filePath4 = "test4.csv";
        String filePath5 = "test5.csv";


        System.out.println(parseCSV(filePath1));
        System.out.println(parseCSV(filePath2));
        System.out.println(parseCSV(filePath3));
        System.out.println(parseCSV(filePath4));
        System.out.println(parseCSV(filePath5));

    }
}