package ZeroShot.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task119 {

    public static void main(String[] args) {
        String[] testCases = {
            "university_records.csv",
            "example.csv",
            "data.csv",
            "test.csv",
            "sample.csv"
        };

        for (String testCase : testCases) {
            parseCSV(testCase);
        }
    }

    public static void parseCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " | ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}