package ourMethod.codestral;
import java.io.*;
import java.util.*;

public class Task94 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        TreeMap<String, String> map = new TreeMap<>();
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                map.put(parts[0].trim(), parts[1].trim());
            }
        }

        br.close();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}