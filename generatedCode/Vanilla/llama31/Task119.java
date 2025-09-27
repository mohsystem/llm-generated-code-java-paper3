package Vanilla.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task119 {
    public static void main(String[] args) {
        String[] testCases = {
            "path/to/test1.csv",
            "path/to/test2.csv",
            "path/to/test3.csv",
            "path/to/test4.csv",
            "path/to/test5.csv"
        };

        for (String testCase : testCases) {
            parseCSVJava(testCase);
        }
    }

    public static void parseCSVJava(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}