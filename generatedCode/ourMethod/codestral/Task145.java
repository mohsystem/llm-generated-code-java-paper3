package ourMethod.codestral;
public class Task145 {
    public static int[] maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0, end = 0, temp = 0;

        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
                temp = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = temp;
                end = i;
            }
        }

        return Arrays.copyOfRange(nums, start, end + 1);
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {-2, -3, 4, -1, -2, 1, 5, -3},
            {-2, 1, -3, 4, -1, 2, 1, -5, 4},
            {1, 2, 3, 4, -10},
            {-1, -2, -3, -4, -5},
            {1, 2, -5, 6, 7, -10, 1, 2, 3}
        };

        for (int[] nums : testCases) {
            System.out.println("Array: " + Arrays.toString(nums));
            System.out.println("Max Subarray: " + Arrays.toString(maxSubArray(nums)));
            System.out.println();
        }
    }
}