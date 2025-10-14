package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.List;

public class Task141 {

    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        List<String> testCases = new ArrayList<>();
        testCases.add("hello");
        testCases.add("world");
        testCases.add("12345");
        testCases.add("");
        testCases.add(null);

        for (String testCase : testCases) {
            System.out.println("Original: " + testCase + " | Reversed: " + reverseString(testCase));
        }
    }
}