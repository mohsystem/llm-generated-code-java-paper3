package Vanilla.codestral;

import java.util.HashSet;
import java.util.Set;

public class Task173 {
    public static String longestDuplicateSubstring(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = (int) s.charAt(i) - (int) 'a';

        int a = 26;
        long mod = (long) Math.pow(2, 32);
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (search(mid, a, mod, nums) != -1)
                left = mid + 1;
            else
                right = mid - 1;
        }

        int start = search(right, a, mod, nums);
        return start != -1 ? s.substring(start, start + right) : "";
    }

    private static int search(int len, int a, long mod, int[] nums) {
        long h = 0;
        for (int i = 0; i < len; ++i)
            h = (h * a % mod + nums[i]) % mod;

        int n = nums.length;
        long aL = 1;
        for (int i = 1; i <= len; ++i)
            aL = (aL * a % mod);

        Set<Long> seen = new HashSet<>();
        for (int start = 0; start < n - len + 1; ++start) {
            if (start != 0) {
                h = (h * a % mod - nums[start - 1] * aL % mod + mod) % mod;
                h = (h + nums[start + len - 1]) % mod;
            }
            if (seen.contains(h))
                return start;
            seen.add(h);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(longestDuplicateSubstring("banana"));  // Output: "ana"
        System.out.println(longestDuplicateSubstring("abcd"));  // Output: ""
    }
}