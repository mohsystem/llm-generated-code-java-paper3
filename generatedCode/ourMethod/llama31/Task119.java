package ourMethod.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task119 {
    public static void main(String[] args) {
        String[] testFiles = {"test1.csv", "test2.csv", "test3.csv", "test4.csv", "test5.csv"};
        for (String file : testFiles) {
            parseCSV(file);
        }
    }

    public static void parseCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " | ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}