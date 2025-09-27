package CoT.gpt4o;
import java.io.*;
import java.util.*;

public class Task119 {
    
    public static List<List<String>> parseCSV(String csvContent) {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(csvContent)) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
        return records;
    }

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next().trim());
            }
        }
        return values;
    }

    public static void main(String[] args) {
        String csvContent = "name,age,city\nAlice,30,New York\nBob,25,Los Angeles\nCharlie,35,Chicago";
        List<List<String>> records = parseCSV(csvContent);
        for (List<String> record : records) {
            System.out.println(record);
        }
    }
}