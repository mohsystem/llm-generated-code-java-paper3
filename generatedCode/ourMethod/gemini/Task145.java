package ourMethod.gemini;
import java.util.Arrays;

class Task145 {
    public static int maxSubArraySum(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int num : nums) {
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] test2 = {1};
        int[] test3 = {5, 4, -1, 7, 8};
        int[] test4 = {-1};
        int[] test5 = {-2, -1};


        System.out.println("Test case 1: " + Arrays.toString(test1) + ", Max sum: " + maxSubArraySum(test1)); // Expected: 6
        System.out.println("Test case 2: " + Arrays.toString(test2) + ", Max sum: " + maxSubArraySum(test2)); // Expected: 1
        System.out.println("Test case 3: " + Arrays.toString(test3) + ", Max sum: " + maxSubArraySum(test3)); // Expected: 23
        System.out.println("Test case 4: " + Arrays.toString(test4) + ", Max sum: " + maxSubArraySum(test4)); // Expected: -1
        System.out.println("Test case 5: " + Arrays.toString(test5) + ", Max sum: " + maxSubArraySum(test5)); // Expected: -1

    }
}