package ourMethod.claude;

public class Task177 {
    public static int maxSubsequenceSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return 0;
        }
        
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
        System.out.println(maxSubsequenceSum(nums4, 3));  // Expected: 15
        
        // Test case 5
        int[] nums5 = {-5};
        System.out.println(maxSubsequenceSum(nums5, 1));  // Expected: -5
    }
}
