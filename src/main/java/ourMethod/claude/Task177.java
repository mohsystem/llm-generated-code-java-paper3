package ourMethod.claude;

import java.util.*;

public class Task177 {
    public static int constrainedSubsetSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        if (k < 1 || k > nums.length) {
            throw new IllegalArgumentException("k must be between 1 and array length");
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            // Remove elements outside the window of size k
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            
            // Calculate dp[i]
            dp[i] = nums[i];
            if (!deque.isEmpty()) {
                dp[i] = Math.max(dp[i], nums[i] + dp[deque.peekFirst()]);
            }
            
            // Maintain decreasing order in deque
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            
            maxSum = Math.max(maxSum, dp[i]);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {10, 2, -10, 5, 20};
        int k1 = 2;
        System.out.println("Test 1: " + constrainedSubsetSum(nums1, k1)); // Expected: 37
        
        // Test case 2
        int[] nums2 = {-1, -2, -3};
        int k2 = 1;
        System.out.println("Test 2: " + constrainedSubsetSum(nums2, k2)); // Expected: -1
        
        // Test case 3
        int[] nums3 = {10, -2, -10, -5, 20};
        int k3 = 2;
        System.out.println("Test 3: " + constrainedSubsetSum(nums3, k3)); // Expected: 23
        
        // Test case 4
        int[] nums4 = {-5, -1, -8, -9};
        int k4 = 3;
        System.out.println("Test 4: " + constrainedSubsetSum(nums4, k4)); // Expected: -1
        
        // Test case 5
        int[] nums5 = {1, 2, 3, 4, 5};
        int k5 = 1;
        System.out.println("Test 5: " + constrainedSubsetSum(nums5, k5)); // Expected: 15
    }
}
