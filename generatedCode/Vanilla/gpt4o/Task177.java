package Vanilla.gpt4o;
import java.util.Deque;
import java.util.LinkedList;

public class Task177 {
    public int maxSubsequenceSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        dp[0] = nums[0];
        deque.add(0);
        int result = nums[0];
        
        for (int i = 1; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            dp[i] = nums[i] + (deque.isEmpty() ? 0 : dp[deque.peekFirst()]);
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.add(i);
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Task177 task = new Task177();
        System.out.println(task.maxSubsequenceSum(new int[]{10, 2, -10, 5, 20}, 2)); // 37
        System.out.println(task.maxSubsequenceSum(new int[]{-1, -2, -3}, 1)); // -1
        System.out.println(task.maxSubsequenceSum(new int[]{10, -2, -10, -5, 20}, 2)); // 23
        System.out.println(task.maxSubsequenceSum(new int[]{1, 2, 3, 4, 5}, 2)); // 15
        System.out.println(task.maxSubsequenceSum(new int[]{5, -1, 5, -2, 5}, 1)); // 12
    }
}