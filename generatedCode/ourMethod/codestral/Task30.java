package ourMethod.codestral;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task30 {
    public static String longest(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (char c : s1.toCharArray()) {
            set.add(c);
        }
        for (char c : s2.toCharArray()) {
            set.add(c);
        }
        Character[] arr = set.toArray(new Character[0]);
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // "abcdefklmopqwxy"
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz"
        System.out.println(longest("abc", "def")); // "abcdef"
        System.out.println(longest("abc", "abc")); // "abc"
        System.out.println(longest("", "")); // ""
    }
}