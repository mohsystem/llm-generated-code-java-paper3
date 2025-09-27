package CoT.codestral;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Task30 {
    public static String longest(String s1, String s2) {
        Set<Character> set = s1.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        set.addAll(s2.chars().mapToObj(e -> (char) e).collect(Collectors.toSet()));
        char[] chars = set.stream().sorted().map(Object::toString).collect(Collectors.joining()).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // "abcdefklmopqwxy"
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz"
    }
}