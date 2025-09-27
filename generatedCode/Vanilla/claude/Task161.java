package Vanilla.claude;

public class Task161 {
    static int knapsack(int capacity, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][capacity + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i-1] <= w)
                    dp[i][w] = Math.max(values[i-1] + dp[i-1][w-weights[i-1]], dp[i-1][w]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        // Test case 1
        int[] values1 = {60, 100, 120};
        int[] weights1 = {10, 20, 30};
        int capacity1 = 50;
        System.out.println("Test 1: " + knapsack(capacity1, weights1, values1, values1.length)); // Expected: 220

        // Test case 2
        int[] values2 = {10, 20, 30, 40};
        int[] weights2 = {1, 2, 3, 4};
        int capacity2 = 5;
        System.out.println("Test 2: " + knapsack(capacity2, weights2, values2, values2.length)); // Expected: 70

        // Test case 3
        int[] values3 = {5, 10, 15, 20, 25};
        int[] weights3 = {2, 4, 6, 8, 10};
        int capacity3 = 15;
        System.out.println("Test 3: " + knapsack(capacity3, weights3, values3, values3.length)); // Expected: 40

        // Test case 4
        int[] values4 = {1, 2, 3};
        int[] weights4 = {4, 5, 6};
        int capacity4 = 3;
        System.out.println("Test 4: " + knapsack(capacity4, weights4, values4, values4.length)); // Expected: 0

        // Test case 5
        int[] values5 = {100};
        int[] weights5 = {1};
        int capacity5 = 1;
        System.out.println("Test 5: " + knapsack(capacity5, weights5, values5, values5.length)); // Expected: 100
    }
}
