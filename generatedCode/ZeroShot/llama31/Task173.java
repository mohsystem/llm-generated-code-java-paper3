package ZeroShot.llama31;
public class Task173 {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - 'a';
        }
        int mod = (int) 1e9 + 9;
        int low = 0, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (search(mid, nums, mod) != -1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return s.substring(search(low - 1, nums, mod), search(low - 1, nums, mod) + low - 1);
    }

    private int search(int length, int[] nums, int mod) {
        long h = 1;
        for (int i = 0; i < length; i++) {
            h = (h * 26) % mod;
        }
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * 26 + nums[i]) % mod;
        }
        Map<Long, Integer> seen = new HashMap<>();
        seen.put(hash, 0);
        for (int start = 1; start < nums.length - length + 1; start++) {
            hash = (hash - h * nums[start - 1] % mod + mod) % mod;
            hash = (hash * 26 + nums[start + length - 1]) % mod;
            if (seen.containsKey(hash)) {
                return seen.get(hash);
            }
            seen.put(hash, start);
        }
        return -1;
    }

    public static void main(String[] args) {
        Task173 task = new Task173();
        System.out.println(task.longestDupSubstring("banana")); // "ana"
        System.out.println(task.longestDupSubstring("abcd")); // ""
        System.out.println(task.longestDupSubstring("abcabc")); // "abc"
        System.out.println(task.longestDupSubstring("aabbcc")); // "bb"
        System.out.println(task.longestDupSubstring("ababab")); // "abab"
    }
}