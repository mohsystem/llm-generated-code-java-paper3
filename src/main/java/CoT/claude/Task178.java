package CoT.claude;

public class Task178 {
    public static int shortestSubarray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        
        for (int start = 0; start < n; start++) {
            long sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];
                if (sum >= k) {
                    minLen = Math.min(minLen, end - start + 1);
                    break;
                }
            }
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1};
        System.out.println(shortestSubarray(nums1, 1));  // Expected: 1
        
        // Test case 2
        int[] nums2 = {1, 2};
        System.out.println(shortestSubarray(nums2, 4));  // Expected: -1
        
        // Test case 3
        int[] nums3 = {2, -1, 2};
        System.out.println(shortestSubarray(nums3, 3));  // Expected: 3
        
        // Test case 4
        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println(shortestSubarray(nums4, 9));  // Expected: 2
        
        // Test case 5
        int[] nums5 = {-1, 2, 3};
        System.out.println(shortestSubarray(nums5, 5));  // Expected: 2
    }
}
