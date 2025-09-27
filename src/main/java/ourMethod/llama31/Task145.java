package ourMethod.llama31;
public class Task145 {
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3, 4, 5},
            {-1, -2, -3, -4, -5},
            {1, -2, 3, -4, 5},
            {-10, 10, -10, 10},
            {0, 0, 0, 0}
        };

        for (int[] testCase : testCases) {
            int maxSum = maxSubArraySum(testCase);
            System.out.println("Maximum subarray sum: " + maxSum);
        }
    }

    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}