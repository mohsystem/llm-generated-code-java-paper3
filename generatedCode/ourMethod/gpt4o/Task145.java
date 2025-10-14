package ourMethod.openai;
public class Task145 {
    public static int maxSubArraySum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // Output: 6
        System.out.println(maxSubArraySum(new int[]{1})); // Output: 1
        System.out.println(maxSubArraySum(new int[]{5, 4, -1, 7, 8})); // Output: 23
        System.out.println(maxSubArraySum(new int[]{-1, -2, -3, -4})); // Output: -1
        System.out.println(maxSubArraySum(new int[]{3, -1, 2, -1})); // Output: 4
    }
}