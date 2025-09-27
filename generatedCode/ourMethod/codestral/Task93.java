package ourMethod.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Task93 {
    public static void main(String[] args) {
        String fileName = "input.txt";
        Map<String, String> data = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    data.put(parts[0].trim(), parts[1].trim());
                } else {
                    System.err.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}