package Vanilla.gemini;
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
        System.out.println(number(test1));

        List<String> test2 = Arrays.asList("a", "b", "c");
        System.out.println(number(test2));

        List<String> test3 = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println(number(test3));

        List<String> test4 = Arrays.asList("");
        System.out.println(number(test4));

        List<String> test5 = Arrays.asList("line1", "", "line3");
        System.out.println(number(test5));

    }
}