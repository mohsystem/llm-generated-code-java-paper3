package CoT.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task173 {
    public static String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (search(s, mid) != -1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int start = search(s, left - 1);
        return start != -1 ? s.substring(start, start + left - 1) : "";
    }

    public static int search(String s, int len) {
        long mod = (long) (1e9 + 7);
        long p = 31;
        long h = 0;
        long[] pow = new long[len];
        pow[0] = 1;
        for (int i = 1; i < len; i++) {
            pow[i] = pow[i - 1] * p % mod;
        }
        for (int i = 0; i < len; i++) {
            h = (h * p + s.charAt(i)) % mod;
        }
        Set<Long> seen = new HashSet<>();
        seen.add(h);
        for (int i = len; i < s.length(); i++) {
            h = (h * p - s.charAt(i - len) * pow[len - 1] % mod + mod) % mod;
            h = (h + s.charAt(i)) % mod;
            if (seen.contains(h)) {
                return i - len + 1;
            }
            seen.add(h);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana")); // Output: "ana"
        System.out.println(longestDupSubstring("abcd")); // Output: ""
    }
}