package ourMethod.gemini;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task30 {

    public static String longest(String s1, String s2) {
        Set<Character> distinctChars = new HashSet<>();
        for (char c : s1.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                distinctChars.add(c);
            }
        }
        for (char c : s2.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                distinctChars.add(c);
            }
        }

        char[] sortedChars = new char[distinctChars.size()];
        int i = 0;
        for (char c : distinctChars) {
            sortedChars[i++] = c;
        }
        Arrays.sort(sortedChars);

        return new String(sortedChars);
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // Output: abcdefklmopqwxy
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // Output: abcdefghijklmnopqrstuvwxyz
        System.out.println(longest("", "")); // Output: 
        System.out.println(longest("abc", "xyz")); // Output: abcxyz
        System.out.println(longest("a", "z")); // Output: az


    }
}