package ourMethod.codestral;
public class Task173 {
    public static String longestDupSubstring(String s) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) s.charAt(i) - (int) 'a';
        }
        int mod = 1000000007;
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (search(arr, n, mid, mod) != -1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int start = search(arr, n, left - 1, mod);
        return start != -1 ? s.substring(start, start + left - 1) : "";
    }

    public static int search(int[] arr, int n, int len, int mod) {
        long h = 0;
        for (int i = 0; i < len; i++) {
            h = (h * 26 + arr[i]) % mod;
        }
        long aL = 1;
        for (int i = 1; i <= len; i++) {
            aL = (aL * 26) % mod;
        }
        java.util.Set<Long> seen = new java.util.HashSet<>();
        seen.add(h);
        for (int start = 1; start <= n - len; start++) {
            h = (h * 26 - arr[start - 1] * aL % mod + mod + arr[start + len - 1]) % mod;
            if (seen.contains(h)) {
                return start;
            }
            seen.add(h);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana"));  // Output: "ana"
        System.out.println(longestDupSubstring("abcd"));    // Output: ""
    }
}