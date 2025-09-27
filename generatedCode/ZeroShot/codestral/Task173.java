package ZeroShot.codestral;
public class Task173 {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - 'a';
        }

        int a = 26;
        long mod = (long) 1e9 + 7;
        long aL = 1;
        for (int i = 1; i < n; i++) {
            aL = (aL * a) % mod;
        }

        int left = 1, right = n;
        int start = -1, length = 0;
        while (left <= right) {
            int len = left + (right - left) / 2;
            long h = 0;
            Set<Long> seen = new HashSet<>();
            for (int i = 0; i < len; i++) {
                h = (h * a + nums[i]) % mod;
            }
            if (seen.add(h)) {
                right = len - 1;
            } else {
                left = len + 1;
                start = len;
            }

            for (int i = len; i < n; i++) {
                h = (h * a - nums[i - len] * aL % mod + mod) % mod;
                h = (h + nums[i]) % mod;
                if (seen.add(h)) {
                    continue;
                }
                start = i - len + 1;
                length = len;
                break;
            }
        }

        return start == -1 ? "" : s.substring(start, start + length);
    }

    public static void main(String[] args) {
        Task173 task = new Task173();
        System.out.println(task.longestDupSubstring("banana")); // "ana"
        System.out.println(task.longestDupSubstring("abcd")); // ""
        System.out.println(task.longestDupSubstring("abcabcabc")); // "abc"
        System.out.println(task.longestDupSubstring("aaaaaa")); // "aaaaa"
        System.out.println(task.longestDupSubstring("abababab")); // "abab"
    }
}