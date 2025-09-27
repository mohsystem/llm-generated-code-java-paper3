package CoT.gpt4o;
import java.util.*;

public class Task177 {
    public static int maxSumSubsequence(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        
        dp[0] = nums[0];
        deque.add(0);

        for (int i = 1; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k) {
                deque.poll();
            }
            dp[i] = nums[i] + (deque.isEmpty() ? 0 : dp[deque.peek()]);
            maxSum = Math.max(maxSum, dp[i]);
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.add(i);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubsequence(new int[]{10, 2, -10, 5, 20}, 2)); // Output: 37
        System.out.println(maxSumSubsequence(new int[]{-1, -2, -3}, 1)); // Output: -1
        System.out.println(maxSumSubsequence(new int[]{10, -2, -10, -5, 20}, 2)); // Output: 23
        System.out.println(maxSumSubsequence(new int[]{5, 3, 2, -1, 4}, 3)); // Output: 13
        System.out.println(maxSumSubsequence(new int[]{1, -1, -1, 1, 1}, 1)); // Output: 2
    }
}