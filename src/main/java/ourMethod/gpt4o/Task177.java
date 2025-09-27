package ourMethod.gpt4o;
import java.util.Deque;
import java.util.LinkedList;

public class Task177 {
    public static int maxSubsequenceSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = nums[0];
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);
        
        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            dp[i] = nums[i] + (deque.isEmpty() ? 0 : Math.max(0, dp[deque.peekFirst()]));
            maxSum = Math.max(maxSum, dp[i]);
            
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubsequenceSum(new int[]{10, 2, -10, 5, 20}, 2)); // 37
        System.out.println(maxSubsequenceSum(new int[]{-1, -2, -3}, 1)); // -1
        System.out.println(maxSubsequenceSum(new int[]{10, -2, -10, -5, 20}, 2)); // 23
        System.out.println(maxSubsequenceSum(new int[]{1, 2, 3, 4, 5}, 3)); // 15
        System.out.println(maxSubsequenceSum(new int[]{5, -1, 2, 3, 4}, 2)); // 12
    }
}