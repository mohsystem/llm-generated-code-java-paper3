package ZeroShot.claude;

public class Task114 {
    public static String copyString(String input) {
        if (input == null) return null;
        return new String(input);
    }
    
    public static String concatenateStrings(String str1, String str2) {
        if (str1 == null || str2 == null) return null;
        return str1 + str2;
    }
    
    public static String reverseString(String input) {
        if (input == null) return null;
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
    
    public static String toUpperCase(String input) {
        if (input == null) return null;
        return input.toUpperCase();
    }
    
    public static int countOccurrences(String str, char ch) {
        if (str == null) return 0;
        return (int) str.chars().filter(c -> c == ch).count();
    }
    
    public static void main(String[] args) {
        // Test case 1
        System.out.println(copyString("Hello")); // Hello
        
        // Test case 2
        System.out.println(concatenateStrings("Hello ", "World")); // Hello World
        
        // Test case 3
        System.out.println(reverseString("Hello")); // olleH
        
        // Test case 4
        System.out.println(toUpperCase("hello")); // HELLO
        
        // Test case 5
        System.out.println(countOccurrences("hello", 'l')); // 2
    }
}
