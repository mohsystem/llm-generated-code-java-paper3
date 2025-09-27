package Vanilla.claude;

public class Task113 {
    public static String concatenateStrings(String... strings) {
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println(concatenateStrings("Hello", " ", "World"));
        
        // Test case 2
        System.out.println(concatenateStrings("Java", "Python", "CPP", "C"));
        
        // Test case 3
        System.out.println(concatenateStrings("One", " ", "Two", " ", "Three"));
        
        // Test case 4
        System.out.println(concatenateStrings("Programming", "-", "Languages"));
        
        // Test case 5
        System.out.println(concatenateStrings("Test", "-", "Case", "-", "Five"));
    }
}
