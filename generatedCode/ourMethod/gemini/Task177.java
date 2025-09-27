package ourMethod.gemini;
import java.util.Arrays;

class Task177 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int maxSum = 0;
            for (int j = Math.max(0, i - k); j < i; j++) {
                maxSum = Math.max(maxSum, dp[j]);
            }
            dp[i] = Math.max(nums[i], nums[i] + maxSum);
        }

        int maxSubsequenceSum = Integer.MIN_VALUE;
        for (int sum : dp) {
            maxSubsequenceSum = Math.max(maxSubsequenceSum, sum);
        }

        return maxSubsequenceSum;
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