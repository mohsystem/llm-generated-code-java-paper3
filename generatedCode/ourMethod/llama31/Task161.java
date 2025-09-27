package ourMethod.llama31;
public class Task161 {
    public static int knapsack(int capacity, int[] weights, int[] values, int n) {
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
        // Test cases
        int[] weights1 = {10, 20, 30, 40};
        int[] values1 = {30, 10, 40, 20};
        int capacity1 = 40;
        int n1 = values1.length;
        System.out.println("Maximum value for test case 1: " + knapsack(capacity1, weights1, values1, n1));

        int[] weights2 = {1, 2, 3, 6, 7, 4};
        int[] values2 = {10, 20, 30, 40, 60, 70};
        int capacity2 = 7;
        int n2 = values2.length;
        System.out.println("Maximum value for test case 2: " + knapsack(capacity2, weights2, values2, n2));

        int[] weights3 = {5, 10, 15};
        int[] values3 = {50, 100, 150};
        int capacity3 = 25;
        int n3 = values3.length;
        System.out.println("Maximum value for test case 3: " + knapsack(capacity3, weights3, values3, n3));

        int[] weights4 = {2, 3, 5};
        int[] values4 = {10, 20, 30};
        int capacity4 = 6;
        int n4 = values4.length;
        System.out.println("Maximum value for test case 4: " + knapsack(capacity4, weights4, values4, n4));

        int[] weights5 = {1, 1, 1};
        int[] values5 = {10, 20, 30};
        int capacity5 = 2;
        int n5 = values5.length;
        System.out.println("Maximum value for test case 5: " + knapsack(capacity5, weights5, values5, n5));
    }
}