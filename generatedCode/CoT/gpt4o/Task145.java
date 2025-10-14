package CoT.openai;
public class Task145 {

    // Function to find the maximum sum of contiguous subarray
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(maxSubArray(new int[]{1})); // 1
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8})); // 23
        System.out.println(maxSubArray(new int[]{-1, -2, -3, -4})); // -1
        System.out.println(maxSubArray(new int[]{-1, 2, 3, -4, 5})); // 6
    }
}