package Vanilla.gemini;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task30 {

    public static String longest(String s1, String s2) {
        Set<Character> charSet = new HashSet<>();
        for (char c : s1.toCharArray()) {
            charSet.add(c);
        }
        for (char c : s2.toCharArray()) {
            charSet.add(c);
        }

        char[] result = new char[charSet.size()];
        int i = 0;
        for (char c : charSet) {
            result[i++] = c;
        }
        Arrays.sort(result);
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // abcdefklmopqwxy
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // abcdefghijklmnopqrstuvwxyz
        System.out.println(longest("", "")); // 
        System.out.println(longest("abcdefg", "hijklmn")); // abcdefghijklmn
        System.out.println(longest("aabbccddeeff", "aabbccddeeff")); // abcdef

    }
}