package ourMethodv2.gpt4o;
import java.util.Deque;
import java.util.LinkedList;

public class Task177 {
    public int maxSumSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            
            dp[i] = nums[i] + (deque.isEmpty() ? 0 : dp[deque.peekFirst()]);
            
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            maxSum = Math.max(maxSum, dp[i]);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        Task177 task = new Task177();
        System.out.println(task.maxSumSubsequence(new int[]{10, 2, -10, 5, 20}, 2)); // Output: 37
        System.out.println(task.maxSumSubsequence(new int[]{-1, -2, -3}, 1)); // Output: -1
        System.out.println(task.maxSumSubsequence(new int[]{10, -2, -10, -5, 20}, 2)); // Output: 23
        System.out.println(task.maxSumSubsequence(new int[]{3, 2, -5, 10, 7}, 3)); // Output: 15
        System.out.println(task.maxSumSubsequence(new int[]{4, -1, 2, -6, 8}, 2)); // Output: 10
    }
}