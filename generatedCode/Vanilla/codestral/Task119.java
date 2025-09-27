package Vanilla.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task119 {
    public static void main(String[] args) {
        List<List<String>> data = readCSV("path_to_your_file.csv");
        // Now you can process the data
    }

    public static List<List<String>> readCSV(String fileName) {
        List<List<String>> data = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                List<String> record = new ArrayList<>();
                for (String value : values) {
                    record.add(value);
                }
                data.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}