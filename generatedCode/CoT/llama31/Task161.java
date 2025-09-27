package CoT.llama31;
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
        int[] values1 = {10, 20, 30, 40, 60, 70};
        int[] weights1 = {1, 2, 3, 6, 7, 4};
        int capacity1 = 7;
        int n1 = values1.length;
        System.out.println("Knapsack value is: " + knapSack(values1, weights1, n1, capacity1));

        int[] values2 = {1, 2, 3};
        int[] weights2 = {1, 2, 3};
        int capacity2 = 4;
        int n2 = values2.length;
        System.out.println("Knapsack value is: " + knapSack(values2, weights2, n2, capacity2));

        int[] values3 = {5, 10, 15};
        int[] weights3 = {2, 3, 4};
        int capacity3 = 6;
        int n3 = values3.length;
        System.out.println("Knapsack value is: " + knapSack(values3, weights3, n3, capacity3));

        int[] values4 = {1, 1, 1};
        int[] weights4 = {1, 1, 1};
        int capacity4 = 2;
        int n4 = values4.length;
        System.out.println("Knapsack value is: " + knapSack(values4, weights4, n4, capacity4));

        int[] values5 = {10, 20};
        int[] weights5 = {1, 2};
        int capacity5 = 3;
        int n5 = values5.length;
        System.out.println("Knapsack value is: " + knapSack(values5, weights5, n5, capacity5));
    }
}