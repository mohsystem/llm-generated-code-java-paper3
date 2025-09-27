package ourMethod.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task25 {
    public static List<String> number(List<String> lines) {
        List<String> numberedLines = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            numberedLines.add((i + 1) + ": " + lines.get(i));
        }
        return numberedLines;
    }

    public static void main(String[] args) {
        List<String> test1 = new ArrayList<>();
        System.out.println(number(test1)); // Output: []

        List<String> test2 = Arrays.asList("a", "b", "c");
        System.out.println(number(test2)); // Output: [1: a, 2: b, 3: c]

        List<String> test3 = Arrays.asList("Hello", "world", "!");
        System.out.println(number(test3)); // Output: [1: Hello, 2: world, 3: !]

        List<String> test4 = Arrays.asList("");
        System.out.println(number(test4)); // Output: [1: ]

        List<String> test5 = Arrays.asList("Line 1", "Line 2", "Line 3", "Line 4");
        System.out.println(number(test5)); // Output: [1: Line 1, 2: Line 2, 3: Line 3, 4: Line 4]

    }
}