package CoT.gemini;
import java.util.Arrays;

class Task145 {
    public static int maxSubArraySum(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int currentMax = 0;

        for (int num : nums) {
            currentMax += num;
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(nums1)); // Output: 6

        int[] nums2 = {-1};
        System.out.println(maxSubArraySum(nums2)); // Output: -1

        int[] nums3 = {1};
        System.out.println(maxSubArraySum(nums3)); // Output: 1

        int[] nums4 = {5, 4, -1, 7, 8};
        System.out.println(maxSubArraySum(nums4)); // Output: 23

        int[] nums5 = {-2, -3, -1, -5};
        System.out.println(maxSubArraySum(nums5)); // Output: -1

    }
}