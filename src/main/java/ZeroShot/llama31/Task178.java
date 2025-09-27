package ZeroShot.llama31;
import java.util.Deque;
import java.util.LinkedList;

public class Task178 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            while (!queue.isEmpty() && prefixSum[i] - prefixSum[queue.peekFirst()] >= k) {
                ans = Math.min(ans, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && prefixSum[i] <= prefixSum[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Task178 task = new Task178();
        int[][] testCases = {
            {1}, {1, 2}, {2, -1, 2}, {2, 1, 1, -4, 3, 1, -1, 2}, {-8, -8, -3, 8}
        };
        int[] ks = {1, 4, 3, 5, 5};
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Input: nums = " + java.util.Arrays.toString(testCases[i]) + ", k = " + ks[i]);
            System.out.println("Output: " + task.shortestSubarray(testCases[i], ks[i]));
        }
    }
}