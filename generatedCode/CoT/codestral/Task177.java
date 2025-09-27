package CoT.codestral;
public class Task177 {
    public static int maxSumSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            for (int j = i - 1; j >= 0 && i - j <= k; j--) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(maxSumSubsequence(new int[]{10,2,-10,5,20}, 2)); // 37
        System.out.println(maxSumSubsequence(new int[]{-1,-2,-3}, 1)); // -1
        System.out.println(maxSumSubsequence(new int[]{10,-2,-10,-5,20}, 2)); // 23
    }
}