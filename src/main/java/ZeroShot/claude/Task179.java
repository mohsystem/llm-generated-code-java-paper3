package ZeroShot.claude;

import java.util.*;

public class Task179 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements outside current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove elements smaller than current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // Add to result if we have a complete window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums1, k1)));
        
        // Test case 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2)));
        
        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums3, k3)));
        
        // Test case 4
        int[] nums4 = {1, -1};
        int k4 = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums4, k4)));
        
        // Test case 5
        int[] nums5 = {7, 2, 4};
        int k5 = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums5, k5)));
    }
}
