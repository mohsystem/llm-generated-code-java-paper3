package ourMethod.gpt4o;
import java.util.ArrayList;
import java.util.List;

public class Task113 {

    public static String concatenateStrings(List<String> strings) {
        StringBuilder result = new StringBuilder();
        for (String s : strings) {
            result.append(s);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<String> test1 = new ArrayList<>();
        test1.add("Hello");
        test1.add(" ");
        test1.add("World");
        System.out.println(concatenateStrings(test1));

        List<String> test2 = new ArrayList<>();
        test2.add("Java");
        test2.add(" ");
        test2.add("Python");
        System.out.println(concatenateStrings(test2));

        List<String> test3 = new ArrayList<>();
        test3.add("Concatenate");
        test3.add(" ");
        test3.add("Strings");
        System.out.println(concatenateStrings(test3));

        List<String> test4 = new ArrayList<>();
        test4.add("Test");
        test4.add(" ");
        test4.add("Case");
        System.out.println(concatenateStrings(test4));

        List<String> test5 = new ArrayList<>();
        test5.add("Secure");
        test5.add(" ");
        test5.add("Code");
        System.out.println(concatenateStrings(test5));
    }
}