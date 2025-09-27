package ourMethod.gemini;
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

    public static List<KeyValuePair> sortKeyValuePairsFromFile(String filePath) throws IOException {
        List<KeyValuePair> keyValuePairs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2); // Limit split to 2
                if (parts.length == 2) {
                    keyValuePairs.add(new KeyValuePair(parts[0].trim(), parts[1].trim()));
                }
            }
        }
        Collections.sort(keyValuePairs, Comparator.comparing(pair -> pair.key));
        return keyValuePairs;
    }


    public static void main(String[] args) throws IOException {
        // Test cases
        List<KeyValuePair> result1 = sortKeyValuePairsFromFile("test1.txt");
        System.out.println("Test 1:");
        result1.forEach(pair -> System.out.println(pair.key + "=" + pair.value));

        List<KeyValuePair> result2 = sortKeyValuePairsFromFile("test2.txt");
        System.out.println("\nTest 2:");
        result2.forEach(pair -> System.out.println(pair.key + "=" + pair.value));

        List<KeyValuePair> result3 = sortKeyValuePairsFromFile("test3.txt");
        System.out.println("\nTest 3:");
        result3.forEach(pair -> System.out.println(pair.key + "=" + pair.value));

        List<KeyValuePair> result4 = sortKeyValuePairsFromFile("test4.txt");
        System.out.println("\nTest 4:");
        result4.forEach(pair -> System.out.println(pair.key + "=" + pair.value));

        List<KeyValuePair> result5 = sortKeyValuePairsFromFile("test5.txt");
        System.out.println("\nTest 5:");
        result5.forEach(pair -> System.out.println(pair.key + "=" + pair.value));

    }
}