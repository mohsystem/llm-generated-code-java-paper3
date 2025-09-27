package CoT.llama31;
// Java
public class Task113 {
    public static String concatenateStrings(String... args) {
        StringBuilder result = new StringBuilder();
        for (String str : args) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(concatenateStrings("Hello", " ", "World", "!"));
        System.out.println(concatenateStrings("This", " ", "is", " ", "a", " ", "test."));
        System.out.println(concatenateStrings("Concatenating", " ", "multiple", " ", "strings."));
        System.out.println(concatenateStrings("Java", " ", "is", " ", "fun."));
        System.out.println(concatenateStrings("Programming", " ", "is", " ", "awesome."));
    }
}