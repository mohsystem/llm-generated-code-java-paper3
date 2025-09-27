package Vanilla.claude;

import java.io.*;
import java.util.*;

public class Task190 {
    public static List<String> transpose(List<String> input) {
        if (input == null || input.isEmpty()) return new ArrayList<>();
        
        String[][] matrix = new String[input.size()][];
        int maxCols = 0;
        
        // Split each line into array and find max columns
        for (int i = 0; i < input.size(); i++) {
            matrix[i] = input.get(i).split(" ");
            maxCols = Math.max(maxCols, matrix[i].length);
        }

        // Transpose matrix
        List<String> result = new ArrayList<>();
        for (int j = 0; j < maxCols; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < matrix.length; i++) {
                if (j < matrix[i].length) {
                    sb.append(matrix[i][j]);
                }
                if (i != matrix.length - 1) {
                    sb.append(" ");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        List<List<String>> testCases = Arrays.asList(
            Arrays.asList("name age", "alice 21", "ryan 30"),
            Arrays.asList("a b c", "1 2 3", "x y z"),
            Arrays.asList("col1 col2", "val1 val2"),
            Arrays.asList("single"),
            Arrays.asList("header1 header2 header3", "data1 data2 data3")
        );

        for (int i = 0; i < testCases.size(); i++) {
            System.out.println("Test case " + (i + 1) + ":");
            System.out.println("Input:");
            testCases.get(i).forEach(System.out::println);
            System.out.println("Output:");
            transpose(testCases.get(i)).forEach(System.out::println);
            System.out.println();
        }
    }
}
