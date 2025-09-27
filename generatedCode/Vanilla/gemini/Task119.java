package Vanilla.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task119 {
    public static List<List<String>> parseCSV(String filePath) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static void main(String[] args) {
        List<List<String>> result1 = parseCSV("data1.csv");
        System.out.println(result1);
        List<List<String>> result2 = parseCSV("data2.csv");
        System.out.println(result2);
         List<List<String>> result3 = parseCSV("data3.csv");
        System.out.println(result3);
         List<List<String>> result4 = parseCSV("data4.csv");
        System.out.println(result4);
         List<List<String>> result5 = parseCSV("data5.csv");
        System.out.println(result5);

    }
}