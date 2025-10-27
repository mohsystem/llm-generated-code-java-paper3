package ZeroShot.claude;

import java.io.*;
import java.util.*;

public class Task190 {
    public static List<String> transposeFile(List<String> input) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        String[] firstLine = input.get(0).split(" ");
        int rows = input.size();
        int cols = firstLine.length;
        
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = input.get(i).split(" ");
        }
        
        List<String> result = new ArrayList<>();
        for (int j = 0; j < cols; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                sb.append(matrix[i][j]);
                if (i < rows - 1) {
                    sb.append(" ");
                }
            }
            result.add(sb.toString());
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        List<String> tests = Arrays.asList(
            "name age\\nalice 21\\nryan 30",
            "a b c\\n1 2 3\\n4 5 6",
            "x y\\np q\\nm n",
            "test case\\nsome data",
            "col1 col2 col3\\nval1 val2 val3"
        );

        for (String test : tests) {
            System.out.println("Input:");
            System.out.println(test);
            List<String> input = Arrays.asList(test.split("\n"));
            List<String> result = transposeFile(input);
            System.out.println("Output:");
            for (String line : result) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}
