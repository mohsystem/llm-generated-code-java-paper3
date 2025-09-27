package Vanilla.codestral;

import java.util.ArrayDeque;
import java.util.Deque;

public class Task178 {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i <= n; i++) {
            while (!queue.isEmpty() && prefixSum[i] - prefixSum[queue.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - queue.pollFirst());
            }

            while (!queue.isEmpty() && prefixSum[i] <= prefixSum[queue.peekLast()]) {
                queue.pollLast();
            }

            queue.offerLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{1}, 1)); // Output: 1
        System.out.println(shortestSubarray(new int[]{1, 2}, 4)); // Output: -1
        System.out.println(shortestSubarray(new int[]{2, -1, 2}, 3)); // Output: 3
    }
}