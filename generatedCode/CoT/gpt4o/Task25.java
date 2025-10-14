package CoT.openai;
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
        List<String> test3 = List.of("Hello", "World");
        List<String> test4 = List.of("Java", "is", "fun");
        List<String> test5 = List.of("Test", "case", "five");

        System.out.println(numberLines(test1));
        System.out.println(numberLines(test2));
        System.out.println(numberLines(test3));
        System.out.println(numberLines(test4));
        System.out.println(numberLines(test5));
    }
}