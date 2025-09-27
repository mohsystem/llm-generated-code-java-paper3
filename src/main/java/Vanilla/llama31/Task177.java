package Vanilla.llama31;
public class Task177 {
    public static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        int[] queue = new int[k + 1];
        queue[0] = 0;
        int front = 0, rear = 0;

        for (int i = 1; i < n; i++) {
            if (front == rear) {
                front = (front + 1) % (k + 1);
            }
            dp[i] = Math.max(nums[i], nums[i] + dp[queue[front]]);
            max = Math.max(max, dp[i]);
            while (rear > front && dp[queue[rear - 1]] <= dp[i]) {
                rear--;
            }
            queue[rear] = i;
            rear = (rear + 1) % (k + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 2, -10, 5, 20};
        int k1 = 2;
        System.out.println(constrainedSubsetSum(nums1, k1)); // Output: 37

        int[] nums2 = {-1, -2, -3};
        int k2 = 1;
        System.out.println(constrainedSubsetSum(nums2, k2)); // Output: -1

        int[] nums3 = {10, -2, -10, -5, 20};
        int k3 = 2;
        System.out.println(constrainedSubsetSum(nums3, k3)); // Output: 23

        int[] nums4 = {5, -3, 5};
        int k4 = 2;
        System.out.println(constrainedSubsetSum(nums4, k4)); // Output: 10

        int[] nums5 = {-2, -3, -1};
        int k5 = 1;
        System.out.println(constrainedSubsetSum(nums5, k5)); // Output: -1
    }
}