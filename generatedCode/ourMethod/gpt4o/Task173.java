package ourMethod.openai;
import java.util.HashSet;

public class Task173 {
    public static String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n;
        String result = "";
        while (left < right) {
            int mid = left + (right - left) / 2;
            String dup = getDupSubstring(s, mid);
            if (dup != null) {
                result = dup;
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return result;
    }

    private static String getDupSubstring(String s, int length) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - length; i++) {
            String substr = s.substring(i, i + length);
            if (seen.contains(substr)) {
                return substr;
            }
            seen.add(substr);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana")); // "ana"
        System.out.println(longestDupSubstring("abcd")); // ""
        System.out.println(longestDupSubstring("abababab")); // "abab"
        System.out.println(longestDupSubstring("abcdeabcde")); // "abcde"
        System.out.println(longestDupSubstring("aaaaa")); // "aaaa"
    }
}