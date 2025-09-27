package Vanilla.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Task93 {
    public static void main(String[] args) {
        String file = "path_to_your_file";
        try {
            Map<String, String> sortedMap = readAndSortFile(file);
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Map<String, String> readAndSortFile(String file) throws IOException {
        Map<String, String> map = new TreeMap<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                map.put(parts[0], parts[1]);
            }
        }
        br.close();
        return map;
    }
}