package Vanilla.openai;
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
        List<String> test2 = List.of("a", "b", "c");
        List<String> test3 = List.of("first", "second", "third");
        List<String> test4 = List.of("line1");
        List<String> test5 = List.of("Hello", "World!");

        System.out.println(numberLines(test1)); // []
        System.out.println(numberLines(test2)); // ["1: a", "2: b", "3: c"]
        System.out.println(numberLines(test3)); // ["1: first", "2: second", "3: third"]
        System.out.println(numberLines(test4)); // ["1: line1"]
        System.out.println(numberLines(test5)); // ["1: Hello", "2: World!"]
    }
}