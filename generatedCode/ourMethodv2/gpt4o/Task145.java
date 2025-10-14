package ourMethodv2.gpt4o;
public class Task145 {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, -2, 3, 4, -1})); // Output: 7
        System.out.println(maxSubArray(new int[]{-1, -2, -3, -4}));  // Output: -1
        System.out.println(maxSubArray(new int[]{1, 2, 3, 4}));      // Output: 10
        System.out.println(maxSubArray(new int[]{2, -1, 2, 3, 4}));  // Output: 10
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // Output: 6
    }
}