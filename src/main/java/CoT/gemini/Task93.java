package CoT.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task93 {

    public static List<Map.Entry<String, String>> sortKeyValueFile(String filePath) throws IOException {
        List<Map.Entry<String, String>> keyValuePairs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2); // Split into key-value
                if (parts.length == 2) { //Check for valid key-value pair
                    keyValuePairs.add(new HashMap.SimpleEntry<>(parts[0].trim(), parts[1].trim()));
                }
            }
        } catch (IOException e) {
            throw new IOException("Error reading file: " + e.getMessage());
        }

        Collections.sort(keyValuePairs, Comparator.comparing(Map.Entry::getKey));
        return keyValuePairs;
    }


    public static void main(String[] args) {
         String testFile = "test.txt"; // Create a test file
        try {
             List<String> testCases = List.of(
                "key1=value1",
                "key3=value3",
                "key2=value2",
                "key4=value4",
                "key5=value5"
        );


            java.nio.file.Files.write(java.nio.file.Paths.get(testFile), testCases);

            List<Map.Entry<String, String>> sortedPairs = sortKeyValueFile(testFile);
            sortedPairs.forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));



             List<String> testCases2 = List.of(
                "apple=red",
                "banana=yellow",
                "orange=orange",
                "grape=purple",
                "kiwi=green"
        );
            java.nio.file.Files.write(java.nio.file.Paths.get(testFile), testCases2);

             sortedPairs = sortKeyValueFile(testFile);
            sortedPairs.forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));



            List<String> testCases3 = List.of(
                "one=1",
                "two=2",
                "three=3",
                "four=4",
                "five=5"
        );
            java.nio.file.Files.write(java.nio.file.Paths.get(testFile), testCases3);

             sortedPairs = sortKeyValueFile(testFile);
            sortedPairs.forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));


            List<String> testCases4 = List.of(
                "red=apple",
                "yellow=banana",
                "orange=orange",
                "purple=grape",
                "green=kiwi"
        );
            java.nio.file.Files.write(java.nio.file.Paths.get(testFile), testCases4);

             sortedPairs = sortKeyValueFile(testFile);
            sortedPairs.forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));



           List<String> testCases5 = List.of(
                "1=one",
                "2=two",
                "3=three",
                "4=four",
                "5=five"
        );
            java.nio.file.Files.write(java.nio.file.Paths.get(testFile), testCases5);

             sortedPairs = sortKeyValueFile(testFile);
            sortedPairs.forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));




        } catch (IOException e) {
            System.err.println("Error during test: " + e.getMessage());
        }

    }
}