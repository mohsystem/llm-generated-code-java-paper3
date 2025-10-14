package ourMethod.openai;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Task30 {
    public static String longest(String s1, String s2) {
        Set<Character> charSet = new HashSet<>();
        for (char c : s1.toCharArray()) {
            charSet.add(c);
        }
        for (char c : s2.toCharArray()) {
            charSet.add(c);
        }
        char[] charArray = new char[charSet.size()];
        int index = 0;
        for (char c : charSet) {
            charArray[index++] = c;
        }
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(longest("abc", "def"));
        System.out.println(longest("abc", "cba"));
        System.out.println(longest("abcd", "efgh"));
    }
}