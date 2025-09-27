package CoT.codestral;
import java.util.ArrayList;
import java.util.List;

public class Task25 {
    public static List<String> lineNumbering(List<String> lines) {
        List<String> numberedLines = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            numberedLines.add((i + 1) + ": " + lines.get(i));
        }
        return numberedLines;
    }

    public static void main(String[] args) {
        List<String> testCase1 = new ArrayList<>();
        List<String> testCase2 = List.of("a", "b", "c");

        System.out.println(lineNumbering(testCase1)); // []
        System.out.println(lineNumbering(testCase2)); // [1: a, 2: b, 3: c]
    }
}