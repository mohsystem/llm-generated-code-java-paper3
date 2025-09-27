package CoT.llama31;
// Task119.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task119 {
    public static void main(String[] args) {
        String[] testCases = {"test1.csv", "test2.csv", "test3.csv", "test4.csv", "test5.csv"};
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
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}