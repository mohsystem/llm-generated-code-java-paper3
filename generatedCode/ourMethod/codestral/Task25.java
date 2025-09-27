package ourMethod.codestral;
import java.util.ArrayList;
import java.util.List;

public class Task25 {
    public static List<String> numberLines(List<String> lines) {
        List<String> numberedLines = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            numberedLines.add((i + 1) + ": " + lines.get(i));
        }
        return numberedLines;
    }

    public static void main(String[] args) {
        List<String> test1 = new ArrayList<>();
        System.out.println(numberLines(test1)); // []

        List<String> test2 = new ArrayList<>();
        test2.add("a");
        test2.add("b");
        test2.add("c");
        System.out.println(numberLines(test2)); // ["1: a", "2: b", "3: c"]
    }
}