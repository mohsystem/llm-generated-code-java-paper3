package CoT.llama31;
public class Task145 {
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            { -2, -3, 4, -1, -2, 1, 5, -3 },
            { 1, 2, 3, 4, 5 },
            { -1, -2, -3, -4, -5 },
            { 0, 0, 0, 0, 0 },
            { 1, -1, 1, -1, 1 }
        };

        for (int[] testCase : testCases) {
            System.out.println("Maximum subarray sum: " + maxSubArraySum(testCase));
        }
    }
}