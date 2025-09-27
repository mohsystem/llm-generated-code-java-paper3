package Vanilla.llama31;
public class Task173 {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - 'a';
        }
        int low = 1, high = n;
        String res = "";
        while (low <= high) {
            int len = low + (high - low) / 2;
            String dup = rabinKarp(nums, len, n);
            if (dup != null) {
                res = dup;
                low = len + 1;
            } else {
                high = len - 1;
            }
        }
        return res;
    }

    private String rabinKarp(int[] nums, int len, int n) {
        long h = 1;
        for (int i = 0; i < len - 1; i++) {
            h = (h * 26) % 2_000_000_003;
        }
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * 26 + nums[i]) % 2_000_000_003;
        }
        Set<Long> seen = new HashSet<>();
        seen.add(hash);
        for (int start = 1; start < n - len + 1; start++) {
            hash = (hash - h * nums[start - 1] % 2_000_000_003 + 2_000_000_003) % 2_000_000_003;
            hash = (hash * 26 + nums[start + len - 1]) % 2_000_000_003;
            if (!seen.add(hash)) {
                return getSubstring(nums, start, start + len - 1);
            }
        }
        return null;
    }

    private String getSubstring(int[] nums, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append((char) (nums[i] + 'a'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Task173 task = new Task173();
        System.out.println(task.longestDupSubstring("banana")); // "ana"
        System.out.println(task.longestDupSubstring("abcd")); // ""
        System.out.println(task.longestDupSubstring("abcabc")); // "abc"
        System.out.println(task.longestDupSubstring("aabbcc")); // "bb"
        System.out.println(task.longestDupSubstring("abcdefgh")); // ""
    }
}