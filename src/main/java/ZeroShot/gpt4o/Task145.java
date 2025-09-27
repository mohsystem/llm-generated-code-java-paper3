package ZeroShot.gpt4o;
public class Task145 {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(maxSubArray(new int[]{1})); // 1
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8})); // 23
        System.out.println(maxSubArray(new int[]{-1, -2, -3, -4})); // -1
        System.out.println(maxSubArray(new int[]{2, -1, 2, 3, 4, -5})); // 10
    }
}