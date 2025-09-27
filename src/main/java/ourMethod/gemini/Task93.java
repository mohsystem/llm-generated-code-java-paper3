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

    @Override
    public String toString() {
        return key + "=" + value;
    }
}


public class Task93 {

    public static List<KeyValuePair> sortKeyValuePairs(String filePath) throws IOException {
        List<KeyValuePair> keyValuePairs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);  // Limit split to 2 in case value contains "=".
                if (parts.length == 2) {
                    keyValuePairs.add(new KeyValuePair(parts[0], parts[1]));
                }
            }
        }
         Collections.sort(keyValuePairs, Comparator.comparing(pair -> pair.key));
        return keyValuePairs;

    }

    public static void main(String[] args) throws IOException {
        // Test cases
        List<KeyValuePair> result1 = sortKeyValuePairs("test1.txt");
        System.out.println("Test 1: " + result1);

        List<KeyValuePair> result2 = sortKeyValuePairs("test2.txt");
        System.out.println("Test 2: " + result2);

        List<KeyValuePair> result3 = sortKeyValuePairs("test3.txt");
        System.out.println("Test 3: " + result3);


        List<KeyValuePair> result4 = sortKeyValuePairs("test4.txt");
        System.out.println("Test 4: " + result4);

        List<KeyValuePair> result5 = sortKeyValuePairs("test5.txt");
        System.out.println("Test 5: " + result5);
    }
}