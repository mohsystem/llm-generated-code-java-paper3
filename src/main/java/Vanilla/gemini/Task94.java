package Vanilla.gemini;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Task94 {
    public static List<Map.Entry<String, String>> sortKeyValuePairs(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        Map<String, String> keyValuePairs = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("=", 2); // Split into key-value
            if (parts.length == 2) {
                keyValuePairs.put(parts[0].trim(), parts[1].trim());
            }
        }
        scanner.close();

        List<Map.Entry<String, String>> sortedEntries = new ArrayList<>(keyValuePairs.entrySet());
        Collections.sort(sortedEntries, Comparator.comparing(Map.Entry::getKey));
        return sortedEntries;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Map.Entry<String, String>> sortedPairs1 = sortKeyValuePairs("test1.txt");
        System.out.println(sortedPairs1);

        List<Map.Entry<String, String>> sortedPairs2 = sortKeyValuePairs("test2.txt");
        System.out.println(sortedPairs2);


        List<Map.Entry<String, String>> sortedPairs3 = sortKeyValuePairs("test3.txt");
        System.out.println(sortedPairs3);

        List<Map.Entry<String, String>> sortedPairs4 = sortKeyValuePairs("test4.txt");
        System.out.println(sortedPairs4);

        List<Map.Entry<String, String>> sortedPairs5 = sortKeyValuePairs("test5.txt");
        System.out.println(sortedPairs5);
    }
}