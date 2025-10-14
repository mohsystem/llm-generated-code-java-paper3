package ourMethodv2.gpt4o;
import java.util.HashSet;

public class Task173 {

    public static String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n;
        String res = "";
        while (left < right) {
            int mid = left + (right - left) / 2;
            String dup = search(s, mid, n);
            if (dup != null) {
                res = dup;
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return res;
    }

    private static String search(String s, int length, int n) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i <= n - length; i++) {
            String sub = s.substring(i, i + length);
            if (seen.contains(sub)) {
                return sub;
            }
            seen.add(sub);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana")); // "ana"
        System.out.println(longestDupSubstring("abcd")); // ""
        System.out.println(longestDupSubstring("aaaaa")); // "aaaa"
        System.out.println(longestDupSubstring("abcabcbb")); // "abc"
        System.out.println(longestDupSubstring("abcpqrabcpq")); // "abcpq"
    }
}