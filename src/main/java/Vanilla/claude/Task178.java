package Vanilla.claude;

import java.util.ArrayDeque;
import java.util.Deque;

class Task178 {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int result = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.getLast()]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && prefixSum[i] >= prefixSum[deque.getFirst()] + k) {
                result = Math.min(result, i - deque.removeFirst());
            }
            deque.addLast(i);
        }
        
        return result <= n ? result : -1;
    }
    
    public static void main(String[] args) {
        // Test case 1
        System.out.println(shortestSubarray(new int[]{1}, 1));  // Expected: 1
        
        // Test case 2
        System.out.println(shortestSubarray(new int[]{1,2}, 4));  // Expected: -1
        
        // Test case 3
        System.out.println(shortestSubarray(new int[]{2,-1,2}, 3));  // Expected: 3
        
        // Test case 4
        System.out.println(shortestSubarray(new int[]{1,1,1,1,1}, 5));  // Expected: 5
        
        // Test case 5
        System.out.println(shortestSubarray(new int[]{2,3,1,-1,4}, 5));  // Expected: 2
    }
}
