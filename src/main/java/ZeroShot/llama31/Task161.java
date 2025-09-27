package ZeroShot.llama31;
public class Task161 {
    public static int knapSack(int[] values, int[] weights, int n, int capacity) {
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] values = {30, 10, 40, 20};
        int[] weights = {10, 20, 30, 40};
        int capacity = 40;
        int n = values.length;
        System.out.println("Knapsack value is: " + knapSack(values, weights, n, capacity));

        // Test cases
        int[][] valuesTest = {
            {10, 20, 30, 40, 60, 70},
            {60, 100, 120},
            {10, 20, 30},
            {5, 10, 15},
            {20, 30, 40}
        };
        int[][] weightsTest = {
            {1, 2, 3, 6, 7, 4},
            {10, 20, 30},
            {1, 2, 3},
            {1, 2, 3},
            {5, 10, 15}
        };
        int[] capacitiesTest = {7, 50, 5, 5, 20};

        for (int i = 0; i < valuesTest.length; i++) {
            System.out.println("Knapsack value for test case " + (i + 1) + " is: " + knapSack(valuesTest[i], weightsTest[i], valuesTest[i].length, capacitiesTest[i]));
        }
    }
}