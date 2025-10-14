package Vanilla.openai;
import java.io.*;
import java.util.*;

public class Task119 {

    public static List<List<String>> parseCSV(String csvContent) {
        List<List<String>> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new StringReader(csvContent))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> values = Arrays.asList(line.split(","));
                result.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String csv = "name,age,city\nJohn,25,New York\nJane,30,San Francisco";
        List<List<String>> parsedCSV = parseCSV(csv);
        for (List<String> row : parsedCSV) {
            System.out.println(row);
        }
    }
}