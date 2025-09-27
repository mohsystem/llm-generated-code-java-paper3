package CoT.gemini;
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

public class Task94 {

    public static List<KeyValuePair> sortKeyValuePairs(String filePath) throws IOException {
        List<KeyValuePair> pairs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Assuming comma as delimiter
                if (parts.length == 2) {
                    pairs.add(new KeyValuePair(parts[0].trim(), parts[1].trim()));
                }
            }
        }

        Collections.sort(pairs, Comparator.comparing(pair -> pair.key));
        return pairs;
    }

    public static void main(String[] args) throws IOException {
        // Test cases
        List<KeyValuePair> result1 = sortKeyValuePairs("test1.txt");
        System.out.println("Test 1:");
        result1.forEach(pair -> System.out.println(pair.key + ": " + pair.value));

        List<KeyValuePair> result2 = sortKeyValuePairs("test2.txt");
        System.out.println("\nTest 2:");
        result2.forEach(pair -> System.out.println(pair.key + ": " + pair.value));

         List<KeyValuePair> result3 = sortKeyValuePairs("test3.txt");
        System.out.println("\nTest 3:");
        result3.forEach(pair -> System.out.println(pair.key + ": " + pair.value));

         List<KeyValuePair> result4 = sortKeyValuePairs("test4.txt");
        System.out.println("\nTest 4:");
        result4.forEach(pair -> System.out.println(pair.key + ": " + pair.value));

         List<KeyValuePair> result5 = sortKeyValuePairs("test5.txt");
        System.out.println("\nTest 5:");
        result5.forEach(pair -> System.out.println(pair.key + ": " + pair.value));
    }
}