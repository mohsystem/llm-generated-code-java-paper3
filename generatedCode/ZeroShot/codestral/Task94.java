package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Task94 {
    public static void main(String[] args) {
        try {
            System.out.println(sortFile("file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> sortFile(String fileName) throws IOException {
        Map<String, String> map = new TreeMap<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                map.put(parts[0], parts[1]);
            }
        }
        br.close();
        return map;
    }
}