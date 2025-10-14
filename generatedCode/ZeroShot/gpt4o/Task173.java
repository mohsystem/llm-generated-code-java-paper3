package ZeroShot.openai;
import java.util.HashSet;

public class Task173 {
    public static String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String dup = findDuplicate(s, mid);
            if (dup != null) {
                result = dup;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static String findDuplicate(String s, int len) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - len; i++) {
            String substr = s.substring(i, i + len);
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
        System.out.println(longestDupSubstring("ababc")); // "ab"
        System.out.println(longestDupSubstring("aaaaa")); // "aaaa"
        System.out.println(longestDupSubstring("abcabc")); // "abc"
    }
}