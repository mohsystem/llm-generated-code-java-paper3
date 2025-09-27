package ourMethod.llama31;
public class Task177 {
    public static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            int sum = nums[i];
            for (int j = 1; j <= k && i - j >= 0; j++) {
                sum = Math.max(sum, dp[i - j] + nums[i]);
            }
            dp[i] = sum;
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 2, -10, 5, 20};
        int k1 = 2;
        System.out.println(constrainedSubsetSum(nums1, k1)); // Output: 37

        int[] nums2 = {-1, -2, -3};
        int k2 = 1;
        System.out.println(constrainedSubsetSum(nums2, k2)); // Output: -1

        int[] nums3 = {10, -2, -10, -5, 20};
        int k3 = 2;
        System.out.println(constrainedSubsetSum(nums3, k3)); // Output: 23
    }
}