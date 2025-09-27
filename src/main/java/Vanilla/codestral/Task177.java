package Vanilla.codestral;
class Task177 {
    public static int maxSumWithNoConsecutiveElements(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i];
            for (int j = Math.max(0, i - k); j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSumWithNoConsecutiveElements(new int[]{10, 2, -10, 5, 20}, 2)); // Output: 37
        System.out.println(maxSumWithNoConsecutiveElements(new int[]{-1, -2, -3}, 1)); // Output: -1
        System.out.println(maxSumWithNoConsecutiveElements(new int[]{10, -2, -10, -5, 20}, 2)); // Output: 23
    }
}