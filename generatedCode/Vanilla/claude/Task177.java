package Vanilla.claude;

import java.util.*;

public class Task177 {
    public static int maxSubsequenceSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i];
            int maxPrev = 0;
            for (int j = Math.max(0, i - k); j < i; j++) {
                maxPrev = Math.max(maxPrev, dp[j]);
            }
            if (maxPrev > 0) {
                dp[i] += maxPrev;
            }
        }
        
        int maxSum = Integer.MIN_VALUE;
        for (int sum : dp) {
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {10, 2, -10, 5, 20};
        System.out.println(maxSubsequenceSum(nums1, 2));  // Expected: 37

        // Test case 2
        int[] nums2 = {-1, -2, -3};
        System.out.println(maxSubsequenceSum(nums2, 1));  // Expected: -1

        // Test case 3
        int[] nums3 = {10, -2, -10, -5, 20};
        System.out.println(maxSubsequenceSum(nums3, 2));  // Expected: 23

        // Test case 4
        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println(maxSubsequenceSum(nums4, 1));  // Expected: 9

        // Test case 5
        int[] nums5 = {-5, -4, -3, -2, -1};
        System.out.println(maxSubsequenceSum(nums5, 3));  // Expected: -1
    }
}
