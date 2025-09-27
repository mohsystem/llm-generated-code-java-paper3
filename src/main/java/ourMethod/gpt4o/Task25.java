package ourMethod.gpt4o;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(numberLines(new ArrayList<>()));
        System.out.println(numberLines(Arrays.asList("a", "b", "c")));
        System.out.println(numberLines(Arrays.asList("Hello", "World")));
        System.out.println(numberLines(Arrays.asList("Line 1", "Line 2", "Line 3", "Line 4")));
        System.out.println(numberLines(Arrays.asList("Single Line")));
    }
}