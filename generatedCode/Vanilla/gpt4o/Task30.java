package Vanilla.openai;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task30 {
    public static String longest(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (char c : (s1 + s2).toCharArray()) {
            set.add(c);
        }
        char[] result = new char[set.size()];
        int i = 0;
        for (char c : set) {
            result[i++] = c;
        }
        Arrays.sort(result);
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // "abcdefklmopqwxy"
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz"
        System.out.println(longest("abcd", "efgh")); // "abcdefgh"
        System.out.println(longest("aaa", "bbb")); // "ab"
        System.out.println(longest("hello", "world")); // "dehlorw"
    }
}