package ZeroShot.llama31;
public class Task177 {
    public static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        int[] queue = new int[k + 1];
        int front = 0, rear = 0;
        queue[rear++] = 0;

        for (int i = 1; i < n; i++) {
            if (front == rear) {
                front = rear = 0;
                queue[rear++] = i;
                dp[i] = nums[i];
            } else {
                while (front < rear && dp[queue[front]] < dp[queue[rear - 1]]) {
                    front++;
                }
                int idx = queue[front];
                dp[i] = Math.max(dp[idx] + nums[i], nums[i]);
                while (rear > front && i - queue[rear - 1] > k) {
                    rear--;
                }
                while (rear > front && dp[queue[rear - 1]] < dp[i]) {
                    rear--;
                }
                queue[rear++] = i;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {10, 2, -10, 5, 20},
            {-1, -2, -3},
            {10, -2, -10, -5, 20}
        };
        int[] ks = {2, 1, 2};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println(constrainedSubsetSum(testCases[i], ks[i]));
        }
    }
}