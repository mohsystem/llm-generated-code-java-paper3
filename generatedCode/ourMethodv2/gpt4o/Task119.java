package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task119 {
    public static List<String[]> parseCSV(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        // Assuming test.csv exists and has valid CSV data
        List<String[]> result = parseCSV("test.csv");
        for (String[] row : result) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}