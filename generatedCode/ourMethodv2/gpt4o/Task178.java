package ourMethodv2.gpt4o;
import java.util.*;

public class Task178 {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int result = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                result = Math.min(result, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{1}, 1)); // 1
        System.out.println(shortestSubarray(new int[]{1, 2}, 4)); // -1
        System.out.println(shortestSubarray(new int[]{2, -1, 2}, 3)); // 3
        System.out.println(shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167)); // 3
        System.out.println(shortestSubarray(new int[]{56, -21, 56, 35, -9}, 61)); // 2
    }
}