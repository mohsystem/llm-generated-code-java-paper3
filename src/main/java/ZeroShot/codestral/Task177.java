package ZeroShot.codestral;
public class Task177 {
    public int maxSubsequence(int[] nums, int k) {
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        System.arraycopy(nums, 0, dp, 0, nums.length);
        System.arraycopy(nums, 0, prev, 0, nums.length);
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = Math.max(0, i - k); j < i; j++) {
                if (dp[j] + nums[i] > dp[i]) {
                    dp[i] = dp[j] + nums[i];
                    prev[i] = j;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        Task177 task = new Task177();
        System.out.println(task.maxSubsequence(new int[]{10,2,-10,5,20}, 2));
        System.out.println(task.maxSubsequence(new int[]{-1,-2,-3}, 1));
        System.out.println(task.maxSubsequence(new int[]{10,-2,-10,-5,20}, 2));
    }
}