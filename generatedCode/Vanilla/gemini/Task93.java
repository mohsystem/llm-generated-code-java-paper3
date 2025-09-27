package Vanilla.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Task93 {
    public static List<Map.Entry<String, String>> sortKeyValueFile(String filePath) throws IOException {
        Map<String, String> keyValueMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    keyValueMap.put(parts[0].trim(), parts[1].trim());
                }
            }
        }

        List<Map.Entry<String, String>> sortedEntries = new ArrayList<>(keyValueMap.entrySet());
        Collections.sort(sortedEntries, Comparator.comparing(Map.Entry::getKey));
        return sortedEntries;

    }

    public static void main(String[] args) throws IOException {
        List<Map.Entry<String, String>> result1 = sortKeyValueFile("file1.txt");
        System.out.println(result1);

        List<Map.Entry<String, String>> result2 = sortKeyValueFile("file2.txt");
        System.out.println(result2);


        List<Map.Entry<String, String>> result3 = sortKeyValueFile("file3.txt");
        System.out.println(result3);

        List<Map.Entry<String, String>> result4 = sortKeyValueFile("file4.txt");
        System.out.println(result4);

        List<Map.Entry<String, String>> result5 = sortKeyValueFile("file5.txt");
        System.out.println(result5);


    }
}