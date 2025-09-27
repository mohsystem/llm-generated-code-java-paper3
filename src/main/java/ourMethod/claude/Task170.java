package ourMethod.claude;

public class Task170 {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long sum = prefixSum[j + 1] - prefixSum[i];
                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {-2, 5, -1};
        System.out.println(countRangeSum(nums1, -2, 2));  // Expected: 3
        
        // Test case 2
        int[] nums2 = {0};
        System.out.println(countRangeSum(nums2, 0, 0));  // Expected: 1
        
        // Test case 3
        int[] nums3 = {1, -1, 0};
        System.out.println(countRangeSum(nums3, -1, 1));  // Expected: 6
        
        // Test case 4
        int[] nums4 = {2, 3, -1, 4};
        System.out.println(countRangeSum(nums4, 3, 6));  // Expected: 4
        
        // Test case 5
        int[] nums5 = {-1, -2, -3, -4};
        System.out.println(countRangeSum(nums5, -7, -2));  // Expected: 5
    }
}
