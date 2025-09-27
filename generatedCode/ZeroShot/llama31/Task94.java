package ZeroShot.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task94 {
    public static void main(String[] args) {
        String[] testFiles = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
        for (String file : testFiles) {
            sortKeyValueFile(file);
        }
    }

    public static void sortKeyValueFile(String fileName) {
        List<String[]> keyValuePairs = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    keyValuePairs.add(parts);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            return;
        }

        // Sort key-value pairs
        keyValuePairs.sort((a, b) -> a[0].compareTo(b[0]));

        // Print sorted key-value pairs
        for (String[] pair : keyValuePairs) {
            System.out.println(pair[0] + "=" + pair[1]);
        }
    }
}