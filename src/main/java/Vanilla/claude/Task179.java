package Vanilla.claude;

import java.util.*;

public class Task179 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            // remove indices outside current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            
            // remove smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offer(i);
            
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        int k1 = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums1, k1)));
        
        // Test Case 2
        int[] nums2 = {1};
        int k2 = 1; 
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2)));
        
        // Test Case 3
        int[] nums3 = {1,-1};
        int k3 = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums3, k3)));
        
        // Test Case 4
        int[] nums4 = {1,2,3,4,5};
        int k4 = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums4, k4)));
        
        // Test Case 5
        int[] nums5 = {1,2,3,4,5,4,3,2,1};
        int k5 = 4;
        System.out.println(Arrays.toString(maxSlidingWindow(nums5, k5)));
    }
}
