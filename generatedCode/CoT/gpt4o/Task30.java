package CoT.openai;
import java.util.TreeSet;

public class Task30 {
    public static String longest(String s1, String s2) {
        TreeSet<Character> charSet = new TreeSet<>();
        for (char c : (s1 + s2).toCharArray()) {
            charSet.add(c);
        }
        StringBuilder result = new StringBuilder();
        for (char c : charSet) {
            result.append(c);
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // Output: "abcdefklmopqwxy"
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // Output: "abcdefghijklmnopqrstuvwxyz"
        System.out.println(longest("abcd", "efgh")); // Output: "abcdefgh"
        System.out.println(longest("zzz", "abc")); // Output: "abcz"
        System.out.println(longest("aabbcc", "ddeeff")); // Output: "abcdef"
    }
}