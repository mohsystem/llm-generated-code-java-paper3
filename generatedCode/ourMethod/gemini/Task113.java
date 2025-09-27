package ourMethod.gemini;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task113 {

    public static String concatenateStrings(List<String> strings) {
        StringBuilder concatenatedString = new StringBuilder();
        for (String str : strings) {
            concatenatedString.append(str);
        }
        return concatenatedString.toString();
    }

    public static void main(String[] args) {
        // Test cases
        List<String> test1 = new ArrayList<>();
        test1.add("Hello");
        test1.add(" ");
        test1.add("world");
        System.out.println(concatenateStrings(test1)); // Expected: Hello world

        List<String> test2 = new ArrayList<>();
        System.out.println(concatenateStrings(test2)); // Expected: ""

        List<String> test3 = new ArrayList<>();
        test3.add("Java");
        test3.add("Python");
        test3.add("C++");
        test3.add("C");
        System.out.println(concatenateStrings(test3)); // Expected: JavaPythonC++C


        List<String> test4 = new ArrayList<>();
        test4.add("Test");
        test4.add("");
        test4.add("case");
        System.out.println(concatenateStrings(test4)); // Expected: Testcase

        List<String> test5 = new ArrayList<>();
        test5.add("Multiple");
        test5.add(" strings ");
        test5.add("concatenated.");
        System.out.println(concatenateStrings(test5)); // Expected: Multiple strings concatenated.
    }
}