package ourMethod.claude;

import java.util.ArrayDeque;
import java.util.Deque;

public class Task179 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;
        
        // store indices
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            
            // remove smaller numbers in k range as they are not needed
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
        // Test case 1
        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        int k1 = 3;
        int[] result1 = maxSlidingWindow(nums1, k1);
        System.out.print("Test case 1: ");
        for(int num : result1) System.out.print(num + " ");
        System.out.println();
        
        // Test case 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = maxSlidingWindow(nums2, k2);
        System.out.print("Test case 2: ");
        for(int num : result2) System.out.print(num + " ");
        System.out.println();
        
        // Test case 3
        int[] nums3 = {1,-1};
        int k3 = 1;
        int[] result3 = maxSlidingWindow(nums3, k3);
        System.out.print("Test case 3: ");
        for(int num : result3) System.out.print(num + " ");
        System.out.println();
        
        // Test case 4
        int[] nums4 = {1,2,3,4,5};
        int k4 = 3;
        int[] result4 = maxSlidingWindow(nums4, k4);
        System.out.print("Test case 4: ");
        for(int num : result4) System.out.print(num + " ");
        System.out.println();
        
        // Test case 5
        int[] nums5 = {1,2,3,4,5,4,3,2,1};
        int k5 = 4;
        int[] result5 = maxSlidingWindow(nums5, k5);
        System.out.print("Test case 5: ");
        for(int num : result5) System.out.print(num + " ");
        System.out.println();
    }
}
