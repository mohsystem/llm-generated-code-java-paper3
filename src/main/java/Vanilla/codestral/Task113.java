package Vanilla.codestral;
public class Task113 {
    public static String concatenateStrings(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(concatenateStrings("Hello", " ", "World", "!")); // "Hello World!"
        System.out.println(concatenateStrings("I", " ", "love", " ", "coding")); // "I love coding"
        System.out.println(concatenateStrings("Java", "Python", "C++")); // "JavaPythonC++"
        System.out.println(concatenateStrings("1", "2", "3", "4", "5")); // "12345"
        System.out.println(concatenateStrings("apple", "banana", "cherry")); // "applebananacherry"
    }
}