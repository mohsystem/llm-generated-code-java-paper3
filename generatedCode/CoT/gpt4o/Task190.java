package CoT.openai;
import java.util.*;
import java.io.*;

public class Task190 {
    public static List<List<String>> transpose(List<List<String>> matrix) {
        if (matrix == null || matrix.isEmpty()) return Collections.emptyList();
        int rowCount = matrix.size();
        int colCount = matrix.get(0).size();
        List<List<String>> transposed = new ArrayList<>();
        for (int i = 0; i < colCount; i++) {
            List<String> newRow = new ArrayList<>();
            for (int j = 0; j < rowCount; j++) {
                newRow.add(matrix.get(j).get(i));
            }
            transposed.add(newRow);
        }
        return transposed;
    }

    public static void main(String[] args) {
        List<List<String>> input = Arrays.asList(
            Arrays.asList("name", "age"),
            Arrays.asList("alice", "21"),
            Arrays.asList("ryan", "30")
        );

        List<List<String>> result = transpose(input);
        for (List<String> row : result) {
            System.out.println(String.join(" ", row));
        }
    }
}