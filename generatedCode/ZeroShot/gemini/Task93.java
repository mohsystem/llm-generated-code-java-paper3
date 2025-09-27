package ZeroShot.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class KeyValuePair {
    String key;
    String value;

    public KeyValuePair(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class Task93 {
    public static List<KeyValuePair> sortKeyValuePairs(String filePath) throws IOException {
        List<KeyValuePair> pairs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    pairs.add(new KeyValuePair(parts[0].trim(), parts[1].trim()));
                }
            }
        }

        Collections.sort(pairs, Comparator.comparing(pair -> pair.key));
        return pairs;

    }

    public static void main(String[] args) throws IOException {
        List<KeyValuePair> sortedPairs1 = sortKeyValuePairs("test1.txt");
        System.out.println("Test case 1:");
        sortedPairs1.forEach(pair -> System.out.println(pair.key + "=" + pair.value));


        List<KeyValuePair> sortedPairs2 = sortKeyValuePairs("test2.txt");
        System.out.println("\nTest case 2:");
        sortedPairs2.forEach(pair -> System.out.println(pair.key + "=" + pair.value));

        List<KeyValuePair> sortedPairs3 = sortKeyValuePairs("test3.txt");
        System.out.println("\nTest case 3:");
        sortedPairs3.forEach(pair -> System.out.println(pair.key + "=" + pair.value));

        List<KeyValuePair> sortedPairs4 = sortKeyValuePairs("test4.txt");
        System.out.println("\nTest case 4:");
        sortedPairs4.forEach(pair -> System.out.println(pair.key + "=" + pair.value));

        List<KeyValuePair> sortedPairs5 = sortKeyValuePairs("test5.txt");
        System.out.println("\nTest case 5:");
        sortedPairs5.forEach(pair -> System.out.println(pair.key + "=" + pair.value));


    }
}