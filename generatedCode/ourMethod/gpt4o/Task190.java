package ourMethod.openai;
import java.util.ArrayList;
import java.util.List;

public class Task190 {
    public static List<String> transposeContent(List<String> lines) {
        if (lines.isEmpty()) {
            return new ArrayList<>();
        }
        
        String[] firstLineTokens = lines.get(0).split(" ");
        int columnCount = firstLineTokens.length;
        int rowCount = lines.size();
        
        String[][] matrix = new String[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            String[] tokens = lines.get(i).split(" ");
            System.arraycopy(tokens, 0, matrix[i], 0, columnCount);
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < columnCount; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < rowCount; j++) {
                if (j > 0) {
                    sb.append(" ");
                }
                sb.append(matrix[j][i]);
            }
            result.add(sb.toString());
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("name age");
        lines.add("alice 21");
        lines.add("ryan 30");
        
        List<String> transposed = transposeContent(lines);
        for (String line : transposed) {
            System.out.println(line);
        }
        
        // Additional test cases
        List<String> test1 = List.of("a b", "c d");
        System.out.println(transposeContent(test1)); // Should print [a c, b d]

        List<String> test2 = List.of("1 2 3", "4 5 6", "7 8 9");
        System.out.println(transposeContent(test2)); // Should print [1 4 7, 2 5 8, 3 6 9]

        List<String> test3 = List.of("onlyone");
        System.out.println(transposeContent(test3)); // Should print [onlyone]

        List<String> test4 = new ArrayList<>();
        System.out.println(transposeContent(test4)); // Should print []

        List<String> test5 = List.of("x y z");
        System.out.println(transposeContent(test5)); // Should print [x, y, z]
    }
}