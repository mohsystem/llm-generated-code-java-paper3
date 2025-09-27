package ourMethod.claude;

import java.io.*;
import java.util.*;

public class Task190 {
    public static List<String> transposeFile(String fileName) {
        List<List<String>> matrix = new ArrayList<>();
        List<String> result = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split(" ");
                matrix.add(Arrays.asList(parts));
            }
            
            if (matrix.isEmpty()) return result;
            
            int rows = matrix.size();
            int cols = matrix.get(0).size();
            
            for (int j = 0; j < cols; j++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < rows; i++) {
                    if (i > 0) sb.append(" ");
                    sb.append(matrix.get(i).get(j));
                }
                result.add(sb.toString());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Test Case 1: Normal case
            FileWriter fw = new FileWriter("test1.txt");
            fw.write("name age\\nalice 21\\nryan 30");
            fw.close();
            System.out.println("Test 1: " + transposeFile("test1.txt"));

            // Test Case 2: Empty file
            fw = new FileWriter("test2.txt");
            fw.close();
            System.out.println("Test 2: " + transposeFile("test2.txt"));

            // Test Case 3: Single line
            fw = new FileWriter("test3.txt");
            fw.write("a b c");
            fw.close();
            System.out.println("Test 3: " + transposeFile("test3.txt"));

            // Test Case 4: Single column
            fw = new FileWriter("test4.txt");
            fw.write("a\\nb\\nc");
            fw.close();
            System.out.println("Test 4: " + transposeFile("test4.txt"));

            // Test Case 5: Multiple spaces
            fw = new FileWriter("test5.txt");
            fw.write("a  b\\nc  d");
            fw.close();
            System.out.println("Test 5: " + transposeFile("test5.txt"));
        } catch (IOException e) {
            System.err.println("Error in test cases: " + e.getMessage());
        }
    }
}
