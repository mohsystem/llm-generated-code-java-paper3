package Vanilla.codestral;
import java.util.TreeSet;

public class Task30 {
    public static String longest(String s1, String s2) {
        TreeSet<Character> set = new TreeSet<>();
        for (char c : s1.toCharArray()) {
            set.add(c);
        }
        for (char c : s2.toCharArray()) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : set) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // "abcdefklmopqwxy"
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz"
    }
}