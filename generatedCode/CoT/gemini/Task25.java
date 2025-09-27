package CoT.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task25 {
    public static List<String> numberLines(List<String> lines) {
        List<String> numberedLines = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            numberedLines.add((i + 1) + ": " + lines.get(i));
        }
        return numberedLines;
    }

    public static void main(String[] args) {
        List<String> test1 = new ArrayList<>();
        System.out.println(numberLines(test1)); // Expected: []

        List<String> test2 = Arrays.asList("a", "b", "c");
        System.out.println(numberLines(test2)); // Expected: [1: a, 2: b, 3: c]

        List<String> test3 = Arrays.asList("");
        System.out.println(numberLines(test3)); // Expected: [1: ]

        List<String> test4 = Arrays.asList("Hello", "World", "!");
        System.out.println(numberLines(test4)); // Expected: [1: Hello, 2: World, 3: !]

        List<String> test5 = Arrays.asList("Line 1", "Line 2", "Line3");
        System.out.println(numberLines(test5)); //Expected: [1: Line 1, 2: Line 2, 3: Line3]

    }
}