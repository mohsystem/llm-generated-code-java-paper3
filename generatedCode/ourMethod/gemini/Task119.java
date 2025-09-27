package ourMethod.gemini;
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
        String testFile1 = "test1.csv"; // File with standard comma delimiter
        String testFile2 = "test2.csv"; // File with quoted values
        String testFile3 = "test3.csv"; // Empty file
        String testFile4 = "test4.csv"; // File with a single line
        String testFile5 = "test5.csv"; // File with varying number of columns


        System.out.println("Test case 1:");
        List<List<String>> records1 = parseCSV(testFile1);
        for (List<String> record : records1) {
            System.out.println(record);
        }

        System.out.println("\nTest case 2:");
        List<List<String>> records2 = parseCSV(testFile2);
        for (List<String> record : records2) {
            System.out.println(record);
        }

        System.out.println("\nTest case 3:");
        List<List<String>> records3 = parseCSV(testFile3);
        for (List<String> record : records3) {
            System.out.println(record);
        }


        System.out.println("\nTest case 4:");
        List<List<String>> records4 = parseCSV(testFile4);
        for (List<String> record : records4) {
            System.out.println(record);
        }


        System.out.println("\nTest case 5:");
        List<List<String>> records5 = parseCSV(testFile5);
        for (List<String> record : records5) {
            System.out.println(record);
        }
    }
}