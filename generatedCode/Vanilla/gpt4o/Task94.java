package Vanilla.openai;
import java.io.*;
import java.util.*;

public class Task94 {
    public static Map<String, String> readAndSortFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        Map<String, String> map = new TreeMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=", 2);
            if (parts.length == 2) {
                map.put(parts[0].trim(), parts[1].trim());
            }
        }
        reader.close();
        return map;
    }

    public static void main(String[] args) {
        String fileName = "data.txt";
        try {
            Map<String, String> sortedData = readAndSortFile(fileName);
            sortedData.forEach((key, value) -> System.out.println(key + "=" + value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}