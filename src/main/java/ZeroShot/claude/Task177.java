package ZeroShot.claude;

import java.util.PriorityQueue;

class Task177 {
    public static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        dp[0] = nums[0];
        pq.offer(new int[]{dp[0], 0});
        int maxSum = dp[0];
        
        for (int i = 1; i < n; i++) {
            while (!pq.isEmpty() && i - pq.peek()[1] > k) {
                pq.poll();
            }
            
            dp[i] = nums[i];
            if (!pq.isEmpty()) {
                dp[i] = Math.max(dp[i], dp[i] + pq.peek()[0]);
            }
            
            pq.offer(new int[]{dp[i], i});
            maxSum = Math.max(maxSum, dp[i]);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {10,2,-10,5,20};
        System.out.println(constrainedSubsetSum(nums1, 2));  // Expected: 37
        
        // Test case 2
        int[] nums2 = {-1,-2,-3};
        System.out.println(constrainedSubsetSum(nums2, 1));  // Expected: -1
        
        // Test case 3
        int[] nums3 = {10,-2,-10,-5,20};
        System.out.println(constrainedSubsetSum(nums3, 2));  // Expected: 23
        
        // Test case 4
        int[] nums4 = {1,2,3,4,5};
        System.out.println(constrainedSubsetSum(nums4, 1));  // Expected: 15
        
        // Test case 5
        int[] nums5 = {-1,-2,-3,-4,-5};
        System.out.println(constrainedSubsetSum(nums5, 3));  // Expected: -1
    }
}
