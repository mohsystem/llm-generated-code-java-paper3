package ZeroShot.gpt4o;
import java.util.Deque;
import java.util.LinkedList;

public class Task178 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLength = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        Task178 task = new Task178();
        System.out.println(task.shortestSubarray(new int[]{1}, 1)); // Output: 1
        System.out.println(task.shortestSubarray(new int[]{1, 2}, 4)); // Output: -1
        System.out.println(task.shortestSubarray(new int[]{2, -1, 2}, 3)); // Output: 3
        System.out.println(task.shortestSubarray(new int[]{2, 3, 1, -1, 4}, 6)); // Output: 2
        System.out.println(task.shortestSubarray(new int[]{1, -1, 1, 1, 1}, 3)); // Output: 3
    }
}