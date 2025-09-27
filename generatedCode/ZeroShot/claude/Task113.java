package ZeroShot.claude;

public class Task113 {
    public static String concatenateStrings(String... strings) {
        if (strings == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            if (str != null) {
                result.append(str);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(concatenateStrings("Hello", " ", "World")); // Hello World
        System.out.println(concatenateStrings("Test", "1", "2", "3")); // Test123
        System.out.println(concatenateStrings("a", "b", "c", "d", "e")); // abcde
        System.out.println(concatenateStrings("Java", " is ", "awesome")); // Java is awesome
        System.out.println(concatenateStrings(null, "test", null, "case")); // testcase
    }
}
