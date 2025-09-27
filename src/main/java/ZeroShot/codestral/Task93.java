package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Task93 {
    public static void main(String[] args) {
        String fileName = "path_to_your_file.txt";
        try {
            Map<String, String> sortedMap = readAndSortFile(fileName);
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Map<String, String> readAndSortFile(String fileName) throws IOException {
        Map<String, String> map = new TreeMap<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                map.put(parts[0].trim(), parts[1].trim());
            }
        }
        br.close();
        return map;
    }
}