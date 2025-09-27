package CoT.claude;

public class Task170 {
    public static int countRangeSums(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int count = 0;
        long[] sums = new long[nums.length + 1];
        
        // Calculate prefix sums
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        
        // Check all possible ranges
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                long sum = sums[j] - sums[i];
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
        System.out.println(countRangeSums(nums1, -2, 2)); // Expected: 3
        
        // Test case 2
        int[] nums2 = {0};
        System.out.println(countRangeSums(nums2, 0, 0)); // Expected: 1
        
        // Test case 3
        int[] nums3 = {1, 2, 3};
        System.out.println(countRangeSums(nums3, 3, 5)); // Expected: 2
        
        // Test case 4
        int[] nums4 = {-1, -1, -1};
        System.out.println(countRangeSums(nums4, -2, 0)); // Expected: 4
        
        // Test case 5
        int[] nums5 = {1, -1, 1, -1};
        System.out.println(countRangeSums(nums5, -1, 1)); // Expected: 8
    }
}
