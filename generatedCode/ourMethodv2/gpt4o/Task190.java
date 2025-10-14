package ourMethodv2.gpt4o;
import java.io.*;
import java.util.*;

public class Task190 {
    public static List<String> transposeContent(List<String> lines) {
        List<String[]> rows = new ArrayList<>();
        for (String line : lines) {
            rows.add(line.split(" "));
        }
        int numCols = rows.get(0).length;
        List<String> transposedLines = new ArrayList<>();
        for (int i = 0; i < numCols; i++) {
            StringBuilder sb = new StringBuilder();
            for (String[] row : rows) {
                sb.append(row[i]).append(" ");
            }
            transposedLines.add(sb.toString().trim());
        }
        return transposedLines;
    }

    public static void main(String[] args) {
        List<String> lines = Arrays.asList("name age", "alice 21", "ryan 30");
        List<String> result = transposeContent(lines);
        for (String line : result) {
            System.out.println(line);
        }
    }
}