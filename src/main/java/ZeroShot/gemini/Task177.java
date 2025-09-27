package ZeroShot.gemini;
import java.util.Arrays;

public class Task177 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            for (int j = 1; j <= k && i - j >= 0; j++) {
                dp[i] = Math.max(dp[i], nums[i] + dp[i - j]);
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Task177 task = new Task177();
        int[] nums1 = {10, 2, -10, 5, 20};
        int k1 = 2;
        System.out.println(task.constrainedSubsetSum(nums1, k1)); // Output: 37

        int[] nums2 = {-1, -2, -3};
        int k2 = 1;
        System.out.println(task.constrainedSubsetSum(nums2, k2)); // Output: -1

        int[] nums3 = {10, -2, -10, -5, 20};
        int k3 = 2;
        System.out.println(task.constrainedSubsetSum(nums3, k3)); // Output: 23

        int[] nums4 = {1};
        int k4 = 1;
        System.out.println(task.constrainedSubsetSum(nums4, k4)); // Output: 1

        int[] nums5 = {-1, -2, -3, -4, -5};
        int k5 = 2;
        System.out.println(task.constrainedSubsetSum(nums5, k5)); // Output: -1

    }
}