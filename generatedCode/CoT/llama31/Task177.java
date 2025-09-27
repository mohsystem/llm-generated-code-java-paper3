package CoT.llama31;
public class Task177 {
    public static int maximumSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            maxSum = Math.max(maxSum, nums[i]);
            for (int j = 1; j <= k && i - j >= 0; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + nums[i]);
                maxSum = Math.max(maxSum, dp[i]);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 2, -10, 5, 20};
        int k1 = 2;
        System.out.println("Output: " + maximumSum(nums1, k1)); // Output: 37

        int[] nums2 = {-1, -2, -3};
        int k2 = 1;
        System.out.println("Output: " + maximumSum(nums2, k2)); // Output: -1

        int[] nums3 = {10, -2, -10, -5, 20};
        int k3 = 2;
        System.out.println("Output: " + maximumSum(nums3, k3)); // Output: 23

        int[] nums4 = {1, 2, 3, 4, 5};
        int k4 = 3;
        System.out.println("Output: " + maximumSum(nums4, k4)); // Output: 15

        int[] nums5 = {-10, -20, -30};
        int k5 = 2;
        System.out.println("Output: " + maximumSum(nums5, k5)); // Output: -10
    }
}