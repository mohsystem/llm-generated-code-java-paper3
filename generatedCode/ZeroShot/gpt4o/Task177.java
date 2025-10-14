package ZeroShot.openai;
import java.util.Deque;
import java.util.LinkedList;

public class Task177 {

    public int maxSumSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        dp[0] = nums[0];
        deque.offer(0);

        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            dp[i] = nums[i] + (deque.isEmpty() ? 0 : dp[deque.peekFirst()]);
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Task177 task = new Task177();
        System.out.println(task.maxSumSubsequence(new int[]{10, 2, -10, 5, 20}, 2)); // 37
        System.out.println(task.maxSumSubsequence(new int[]{-1, -2, -3}, 1)); // -1
        System.out.println(task.maxSumSubsequence(new int[]{10, -2, -10, -5, 20}, 2)); // 23
        System.out.println(task.maxSumSubsequence(new int[]{1, 2, 3, 4, 5}, 3)); // 15
        System.out.println(task.maxSumSubsequence(new int[]{-5, -1, -3, -4}, 2)); // -1
    }
}