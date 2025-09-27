package CoT.gpt4o;
import java.util.*;

public class Task178 {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        int minLength = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return minLength <= n ? minLength : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{1}, 1)); // Output: 1
        System.out.println(shortestSubarray(new int[]{1, 2}, 4)); // Output: -1
        System.out.println(shortestSubarray(new int[]{2, -1, 2}, 3)); // Output: 3
        System.out.println(shortestSubarray(new int[]{1, 2, 3, 4, 5}, 11)); // Output: 3
        System.out.println(shortestSubarray(new int[]{-1, -2, -3, 4, 5}, 6)); // Output: 2
    }
}