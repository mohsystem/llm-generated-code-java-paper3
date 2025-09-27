package Vanilla.llama31;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task93 {
    public static void main(String[] args) {
        String[] testFiles = {"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"};
        for (String file : testFiles) {
            sortKeyValueRecords(file);
        }
    }

    public static void sortKeyValueRecords(String fileName) {
        List<String> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(records);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String record : records) {
                writer.write(record + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Sorted records in " + fileName + ":");
        for (String record : records) {
            System.out.println(record);
        }
    }
}