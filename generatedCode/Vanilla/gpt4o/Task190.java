package Vanilla.gpt4o;
import java.io.*;
import java.util.*;

public class Task190 {
    public static List<String> transposeContent(List<String> lines) {
        List<List<String>> matrix = new ArrayList<>();
        for (String line : lines) {
            matrix.add(Arrays.asList(line.split(" ")));
        }
        int numRows = matrix.size();
        int numCols = matrix.get(0).size();
        List<String> result = new ArrayList<>();
        for (int j = 0; j < numCols; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                if (i > 0) sb.append(" ");
                sb.append(matrix.get(i).get(j));
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> lines = Arrays.asList(
            "name age",
            "alice 21",
            "ryan 30"
        );

        List<String> transposed = transposeContent(lines);
        for (String line : transposed) {
            System.out.println(line);
        }
    }
}