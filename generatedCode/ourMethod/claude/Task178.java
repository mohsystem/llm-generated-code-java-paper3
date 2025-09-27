package ourMethod.claude;

public class Task178 {
    public static int shortestSubarray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        
        for (int start = 0; start < n; start++) {
            long sum = 0;  // Using long to prevent integer overflow
            for (int end = start; end < n; end++) {
                sum += nums[end];
                if (sum >= k) {
                    minLength = Math.min(minLength, end - start + 1);
                    break;
                }
            }
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(shortestSubarray(new int[]{1}, 1));  // Expected: 1
        System.out.println(shortestSubarray(new int[]{1,2}, 4));  // Expected: -1
        System.out.println(shortestSubarray(new int[]{2,-1,2}, 3));  // Expected: 3
        System.out.println(shortestSubarray(new int[]{1,1,1,1,1}, 5));  // Expected: 5
        System.out.println(shortestSubarray(new int[]{2,3,1,2,4,3}, 7));  // Expected: 2
    }
}
