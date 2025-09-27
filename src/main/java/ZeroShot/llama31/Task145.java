package ZeroShot.llama31;
public class Task145 {
    public static int maxSubArraySum(int[] arr) {
        int bestSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int x : arr) {
            currentSum = Math.max(x, currentSum + x);
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;
    }

    public static void main(String[] args) {
        int[] testCases = {
            -2, 1, -3, 4, -1, 2, 1, -5, 4,
            -2, -5, 6, -2, -3, 1, 5, -6,
            1, 2, 3, 4, 5,
            -1, -2, -3, -4, -5,
            0, 0, 0, 0, 0
        };
        int[] expectedResults = {6, 7, 15, -1, 0};

        for (int i = 0; i < testCases.length; i += 5) {
            int[] testCase = new int[5];
            System.arraycopy(testCases, i, testCase, 0, 5);
            System.out.println("Maximum contiguous sum is: " + maxSubArraySum(testCase));
        }
    }
}