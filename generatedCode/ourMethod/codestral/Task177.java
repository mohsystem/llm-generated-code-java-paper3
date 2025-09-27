package ourMethod.codestral;
public class Task177 {
    public static int max_sum_subsequence(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max_val = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (i >= k) {
                dp[i] = Math.max(dp[i], dp[i - k] + nums[i]);
            }
            max_val = Math.max(max_val, dp[i]);
        }
        return max_val;
    }

    public static void main(String[] args) {
        System.out.println(max_sum_subsequence(new int[]{10,2,-10,5,20}, 2)); // Expected output: 37
        System.out.println(max_sum_subsequence(new int[]{-1,-2,-3}, 1)); // Expected output: -1
        System.out.println(max_sum_subsequence(new int[]{10,-2,-10,-5,20}, 2)); // Expected output: 23
    }
}